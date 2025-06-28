package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "intro_layouts")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class IntroLayoutEntity extends BaseEntity {
    String layoutType;
    String photoFrameStyle;
}
