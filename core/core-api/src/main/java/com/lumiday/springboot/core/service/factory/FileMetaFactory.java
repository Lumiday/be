package com.lumiday.springboot.core.service.factory;

import com.lumiday.core.enums.FileContentType;
import com.lumiday.springboot.core.service.dto.FileMeta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

public class FileMetaFactory {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    private FileMetaFactory() {
    }

    public static FileMeta from(MultipartFile file) {

        String originalName = extractOriginalName(file);
        String extension = extractExtension(originalName);
        String contentType = extractContentType(file);
        FileContentType fileContentType = FileContentType.of(extension, contentType);

        String uuidName = createUuidName(extension);
        String objectName = createObjectName(uuidName);

        return new FileMeta(originalName, uuidName, objectName, extension, fileContentType);
    }

    private static String createObjectName(String uuidName) {
        return String.format("%s/%s", LocalDate.now().format(DATE_PATTERN), uuidName);
    }

    private static @NotNull String createUuidName(String extension) {
        return UUID.randomUUID() + "." + extension;
    }

    private static String extractContentType(MultipartFile file) {
        return Optional.of(file.getContentType())
                .map(n -> n.split(";")[0].trim())
                .orElseThrow(() -> new IllegalArgumentException("ContentType이 없습니다."));
    }

    private static String extractExtension(String originalName) {
        return Optional.of(originalName)
                .filter(n -> n.contains("."))
                .map(n -> n.substring(n.lastIndexOf(".") + 1))
                .orElseThrow(() -> new IllegalArgumentException("파일 확장자가 없습니다."));
    }

    private static String extractOriginalName(MultipartFile file) {
        return Optional.of(file.getOriginalFilename())
                .filter(n -> !n.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("파일 이름이 없습니다."));
    }
}
