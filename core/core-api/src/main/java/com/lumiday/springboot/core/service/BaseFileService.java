package com.lumiday.springboot.core.service;

import com.lumiday.core.enums.FileContentType;
import com.lumiday.springboot.core.implement.client.StorageClient;
import com.lumiday.springboot.core.implement.dto.FileInfo;
import com.lumiday.springboot.core.implement.persistence.FilePersistence;
import com.lumiday.springboot.core.service.dto.FileMeta;
import com.lumiday.springboot.core.service.dto.FileWithType;
import com.lumiday.springboot.core.service.factory.FileMetaFactory;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
public abstract class BaseFileService {

    private final StorageClient storageClient;
    private final FilePersistence filePersistence;

    protected abstract String bucketName();

    protected abstract long maxSizeBytes();

    protected abstract boolean isSupported(FileContentType contentType);

    public String saveFile(MultipartFile file) throws IOException {
        validateFile(file);

        FileMeta fileMeta = FileMetaFactory.from(file);

        if (!isSupported(fileMeta.contentType())) {
            throw new IllegalArgumentException("지원하지 않는 파일 형식입니다.");
        }

        storageClient.uploadToStorage(
                file.getInputStream(),
                file.getSize(),
                fileMeta.objectName(),
                bucketName(),
                fileMeta.contentType().getMimeType()
        );

        try {
            filePersistence.saveFileInfo(
                    fileMeta.originalName(),
                    fileMeta.uuidName(),
                    fileMeta.objectName(),
                    fileMeta.contentType(),
                    file.getSize()
            );
            return fileMeta.uuidName();
        } catch (Exception e) {
            storageClient.deleteFromStorage(bucketName(), fileMeta.objectName());
            throw new RuntimeException("파일 업로드 실패", e);
        }
    }

    public void deleteFile(String uuidName) {
        FileInfo info = filePersistence.findBySavedFileName(uuidName);

        try {
            storageClient.deleteFromStorage(bucketName(), info.getObjectName());
            filePersistence.deleteFileInfo(info.getId());
        } catch (Exception e) {
            throw new RuntimeException("파일 삭제 실패", e);
        }
    }

    public FileWithType getFile(String uuidName) {
        FileInfo info = filePersistence.findBySavedFileName(uuidName);
        byte[] data = storageClient.downloadFromStorage(bucketName(), info.getObjectName());
        MediaType mediaType = info.getContentType().getMediaType();
        return new FileWithType(data, mediaType);
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("파일이 비어 있습니다.");
        }
        if (file.getSize() > maxSizeBytes()) {
            throw new IllegalArgumentException("파일 용량은 " + (maxSizeBytes() / (1024 * 1024)) + "MB를 초과할 수 없습니다.");
        }
    }
}
