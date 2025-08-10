package com.lumiday.springboot.core.controller.dto;

import com.lumiday.springboot.core.domain.EndingDomain;

public record EndingResponse(String title, String content, String imageName) {
    public static EndingResponse of(EndingDomain ending) {
        return new EndingResponse(
                ending.getTitle(),
                ending.getContent(),
                ending.getImageName()
        );
    }
}
