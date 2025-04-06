package com.lumiday.springboot.core.service.dto;

import org.springframework.http.MediaType;


public record ImageWithType(byte[] data, MediaType contentType) {
    public ImageWithType(byte[] data, String extension) {
        this(data, extension == null ? MediaType.APPLICATION_OCTET_STREAM :
                switch (extension.toLowerCase()) {
                    case "image/jpeg" -> MediaType.IMAGE_JPEG;
                    case "image/png" -> MediaType.IMAGE_PNG;
                    case "image/webp" -> MediaType.valueOf("image/webp");
                    default -> MediaType.APPLICATION_OCTET_STREAM;
                });
    }
}
