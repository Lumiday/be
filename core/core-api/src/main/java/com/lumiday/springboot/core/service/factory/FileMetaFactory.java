package com.lumiday.springboot.core.service.factory;

import com.lumiday.springboot.core.service.dto.FileMeta;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.UUID;
import org.springframework.web.multipart.MultipartFile;

public class FileMetaFactory {
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public static FileMeta from(MultipartFile file) {
        String originalName = Optional.of(file.getOriginalFilename())
                .filter(n -> !n.isBlank())
                .orElseThrow(() -> new IllegalArgumentException("파일 이름이 없습니다."));

        String extension = Optional.of(originalName)
                .filter(n -> n.contains("."))
                .map(n -> n.substring(n.lastIndexOf(".")))
                .orElseThrow(() -> new IllegalArgumentException("파일 확장자가 없습니다."));

        String uuidName = UUID.randomUUID() + extension;
        String objectName = String.format("%s/%s", LocalDate.now().format(DATE_PATTERN), uuidName);

        return new FileMeta(originalName, uuidName, objectName, extension);
    }
}
