package com.lumiday.springboot.core.service.dto;

public record FileMeta(
        String originalName,
        String uuidName,
        String objectName,
        String extension
) {
}

