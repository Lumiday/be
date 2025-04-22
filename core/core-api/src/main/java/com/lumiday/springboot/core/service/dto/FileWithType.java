package com.lumiday.springboot.core.service.dto;

import org.springframework.http.MediaType;

public record FileWithType(byte[] data, MediaType mediaType) {
}

