package com.lumiday.springboot.core.implement.dto;

import com.lumiday.core.enums.FileContentType;
import com.lumiday.jpa.entity.FileEntity;
import lombok.Getter;

@Getter
public class FileInfo {
    Long id;
    String originalFileName;
    String savedFileName;
    String objectName;
    FileContentType contentType;
    Long size;

    private FileInfo(Long id, String originalFileName, String savedFileName, String objectName,
                     FileContentType contentType, Long size) {
        this.id = id;
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.objectName = objectName;
        this.contentType = contentType;
        this.size = size;
    }

    public static FileInfo fromEntity(FileEntity entity) {
        return new FileInfo(
                entity.getId(),
                entity.getOriginalFileName(),
                entity.getSavedFileName(),
                entity.getObjectName(),
                entity.getContentType(),
                entity.getSize()
        );
    }
}
