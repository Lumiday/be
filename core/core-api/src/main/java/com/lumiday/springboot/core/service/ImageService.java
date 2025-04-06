package com.lumiday.springboot.core.service;

import com.lumiday.springboot.core.implement.client.StorageClient;
import com.lumiday.springboot.core.implement.dto.FileInfo;
import com.lumiday.springboot.core.implement.persistence.FilePersistence;
import com.lumiday.springboot.core.service.dto.FileNamingInfo;
import com.lumiday.springboot.core.service.dto.ImageWithType;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class ImageService {

    private static final List<String> ALLOWED_IMAGE_TYPES = List.of("image/jpeg", "image/png", "image/webp");
    private static final long MAX_FILE_SIZE = 20 * 1024 * 1024;
    private final StorageClient storageClient;
    private final FilePersistence filePersistence;

    public String saveImage(MultipartFile file) throws IOException {
        validateFile(file);

        FileNamingInfo naming = generateFileNames(file.getOriginalFilename());

        storageClient.uploadToStorage(file.getInputStream(), file.getSize(), naming.objectName(),
                file.getContentType());

        try {
            filePersistence.saveFileInfo(
                    file.getOriginalFilename(),
                    naming.uuidName(),
                    naming.objectName(),
                    file.getContentType(),
                    file.getSize()
            );
            return naming.uuidName();
        } catch (Exception e) {
            safeDelete(naming.objectName());
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    public void deleteImage(String imageName) {
        try {
            filePersistence.deleteFileInfo(imageName);
            storageClient.deleteFromStorage(imageName);
        } catch (Exception e) {
            throw new RuntimeException("파일 삭제 실패", e);
        }
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어 있습니다.");
        }

        if (!ALLOWED_IMAGE_TYPES.contains(file.getContentType())) {
            throw new IllegalArgumentException("지원하지 않는 이미지 형식입니다.");
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("파일 용량은 20MB를 초과할 수 없습니다.");
        }
    }

    private FileNamingInfo generateFileNames(String originalName) {
        String extension = getExtension(originalName);
        String uuidName = UUID.randomUUID() + extension;
        String datePath = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String objectName = String.format("%s/%s", datePath, uuidName);

        return new FileNamingInfo(uuidName, objectName);
    }

    private String getExtension(String fileName) {
        return Optional.ofNullable(fileName)
                .filter(name -> name.contains("."))
                .map(name -> name.substring(fileName.lastIndexOf(".")))
                .orElse("");
    }

    private void safeDelete(String objectName) {
        try {
            storageClient.deleteFromStorage(objectName);
        } catch (Exception ignored) {
        }
    }

    public ImageWithType getImage(String imageName) {
        FileInfo image = filePersistence.findBySavedFileName(imageName);
        byte[] data = storageClient.downloadFromStorage(image.getObjectName());
        return new ImageWithType(data, image.getContentType());
    }
}
