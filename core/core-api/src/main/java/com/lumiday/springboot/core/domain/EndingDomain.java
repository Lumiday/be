package com.lumiday.springboot.core.domain;

import com.lumiday.springboot.core.controller.dto.EndingRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EndingDomain {
    private String title;
    private String content;
    private String imageName;

    public static EndingDomain of(EndingRequest request) {
        return new EndingDomain(
                request.title(),
                request.content(),
                request.imageName()
        );
    }

    public static EndingDomain of(String title, String content, String imageName) {
        return new EndingDomain(
                title, content, imageName
        );
    }
}
