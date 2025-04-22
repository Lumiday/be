package com.lumiday.core.enums;

import java.util.Arrays;
import java.util.List;
import lombok.Getter;
import org.springframework.http.MediaType;

@Getter
public enum FileContentType {

    JPEG("image/jpeg", MediaType.IMAGE_JPEG, List.of("jpg", "jpeg")),
    PNG("image/png", MediaType.IMAGE_PNG, List.of("png")),
    WEBP("image/webp", MediaType.valueOf("image/webp"), List.of("webp")),
    MP3("audio/mpeg", MediaType.parseMediaType("audio/mpeg"), List.of("mp3"));

    private final String mimeType;
    private final MediaType mediaType;
    private final List<String> extensions;
    private final Category category;

    FileContentType(String mimeType, MediaType mediaType, List<String> extensions) {
        this.mimeType = mimeType;
        this.mediaType = mediaType;
        this.extensions = extensions;
        this.category = Category.from(mimeType);
    }

    public static FileContentType of(String extension, String mimeType) {
        return Arrays.stream(values())
                .filter(f -> f.matches(extension, mimeType))
                .findFirst()
                .orElseThrow(() ->
                        new IllegalArgumentException("지원하지 않는 파일 형식입니다. 확장자: " + extension + ", MIME: " + mimeType));
    }

    public boolean matches(String extension, String mimeType) {
        return extensions.contains(extension.toLowerCase()) && this.mimeType.equalsIgnoreCase(mimeType);
    }

    public boolean isImage() {
        return category == Category.IMAGE;
    }

    public boolean isAudio() {
        return category == Category.AUDIO;
    }

    private enum Category {
        IMAGE(List.of("image/jpeg", "image/png", "image/webp")),
        AUDIO(List.of("audio/mpeg"));

        private final List<String> mimeTypes;

        Category(List<String> mimeTypes) {
            this.mimeTypes = mimeTypes;
        }

        private static Category from(String mimeType) {
            return Arrays.stream(values())
                    .filter(c -> c.mimeTypes.contains(mimeType))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("지원하지 않는 MIME 타입입니다: " + mimeType));
        }
    }
}


