package com.lumiday.jpa.entity;

import com.lumiday.core.enums.GalleryType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "galleries")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class GalleryEntity extends BaseEntity {
    private String name;
    private GalleryType type;
    private Boolean usePopUpView;
    private List<String> images;
}
