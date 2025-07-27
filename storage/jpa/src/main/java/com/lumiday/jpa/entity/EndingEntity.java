package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "endings")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EndingEntity extends BaseEntity {

    private String title;
    private String content;
    private String imageName;

    public static EndingEntity of(String title, String content, String imageName) {
        return new EndingEntity(title, content, imageName);
    }
}
