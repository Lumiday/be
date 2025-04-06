package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileEntity extends BaseEntity {

    private String originalFileName;
    private String savedFileName;
    private String objectName;
    private String contentType;
    private Long size;

    @Builder
    public FileEntity(String originalFileName, String savedFileName, String objectName,
                      String contentType, Long size) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.objectName = objectName;
        this.contentType = contentType;
        this.size = size;
    }
}
