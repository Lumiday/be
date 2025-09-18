package com.lumiday.jpa.vo;

import com.lumiday.core.enums.GalleryType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Gallery {

    @Column(name = "gallery_name")
    private String name;

    @Column(name = "gallery_type")
    @Enumerated(EnumType.STRING)
    private GalleryType type;

    @Column(name = "gallery_use_popup")
    private Boolean usePopUpView;

    @ElementCollection
    @CollectionTable(
            name = "gallery_images",
            joinColumns = @JoinColumn(name = "invitation_id")
    )
    @Column(name = "gallery_image")
    private List<String> images;

    public static Gallery of(String name, GalleryType type, Boolean usePopUpView, List<String> images) {
        if (name == null || type == null) {
            throw new IllegalArgumentException("name과 type은 필수입니다.");
        }
        Gallery gallery = new Gallery();
        gallery.name = name;
        gallery.type = type;
        gallery.usePopUpView = usePopUpView != null ? usePopUpView : Boolean.FALSE;
        gallery.images = images != null ? new ArrayList<>(images) : new ArrayList<>();
        return gallery;
    }
}
