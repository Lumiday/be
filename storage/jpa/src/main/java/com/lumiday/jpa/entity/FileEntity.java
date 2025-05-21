package com.lumiday.jpa.entity;

import com.lumiday.core.enums.FileContentType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "files")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FileEntity extends BaseEntity {

    private String originalFileName;
    private String savedFileName;
    private String objectName;
    @Enumerated(EnumType.STRING)
    private FileContentType contentType;
    private Long size;

    private FileEntity(String originalFileName, String savedFileName, String objectName,
                       FileContentType contentType, Long size) {
        this.originalFileName = originalFileName;
        this.savedFileName = savedFileName;
        this.objectName = objectName;
        this.contentType = contentType;
        this.size = size;
    }

    public static FileEntity of(String originalFileName, String savedFileName, String objectName,
                                FileContentType contentType, Long size) {
        return new FileEntity(originalFileName, savedFileName, objectName, contentType, size);
    }
}
