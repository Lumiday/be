package com.lumiday.springboot.core.service.dto;

import com.lumiday.core.enums.FileContentType;

public record FileMeta(
        String originalName,
        String uuidName,
        String objectName,
        String extension,
        FileContentType contentType
) {
}

