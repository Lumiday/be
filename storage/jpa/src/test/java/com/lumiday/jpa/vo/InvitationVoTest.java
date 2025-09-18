package com.lumiday.jpa.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.lumiday.core.enums.AccountDesignType;
import com.lumiday.core.enums.AttendanceType;
import com.lumiday.core.enums.DeceasedDisplayType;
import com.lumiday.core.enums.GalleryType;
import com.lumiday.core.enums.PersonRole;
import com.lumiday.core.enums.PhotoFrameStyle;
import com.lumiday.core.enums.ThemeColor;
import com.lumiday.core.enums.ThemeFontFamily;
import com.lumiday.core.enums.ThemeFontSize;
import com.lumiday.core.enums.ThemePattern;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class InvitationVoTest {
    @Test
    void accountDetail_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> AccountDetail.of(null, "bank", "123", true))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> AccountDetail.of("owner", null, "123", true))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> AccountDetail.of("owner", "bank", null, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void accountDetail_shouldSetDefaults() {
        AccountDetail ad = AccountDetail.of("owner", "bank", "123", null);
        assertThat(ad.getKakaoPayEnabled()).isNull();
    }

    @Test
    void accountGroup_shouldInitializeListAndFailWithoutName() {
        assertThatThrownBy(() -> AccountGroup.of(null, null)).isInstanceOf(IllegalArgumentException.class);

        AccountGroup group = AccountGroup.of("group1", null);
        assertThat(group.getAccountDetails()).isNotNull().isEmpty();
    }

    @Test
    void accountInfo_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> AccountInfo.of(null, "content", AccountDesignType.BASIC, null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void attendanceCheck_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> AttendanceCheck.of(null, "content", "btn", AttendanceType.ETC))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void backgroundMusic_shouldSetDefaults() {
        BackgroundMusic bgm = BackgroundMusic.of("song", null);
        assertThat(bgm.getAutoplay()).isFalse();
    }

    @Test
    void ending_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> Ending.of(null, "content", "img"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void gallery_shouldSetDefaults() {
        Gallery gallery = Gallery.of("name", GalleryType.CHECKERBOARD, null, null);
        assertThat(gallery.getUsePopUpView()).isFalse();
        assertThat(gallery.getImages()).isNotNull().isEmpty();
    }

    @Test
    void introLayout_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> IntroLayout.of(null, PhotoFrameStyle.FRAME, "img"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invitationMessage_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> InvitationMessage.of(null, "content"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void personBaseInfo_shouldSetDefaults() {
        PersonBaseInfo baseInfo = PersonBaseInfo.of(DeceasedDisplayType.CHRYSANTHEMUM, null);
        assertThat(baseInfo.getPersonInfos()).isEmpty();
    }

    @Test
    void personInfo_shouldSetDefaults() {
        PersonInfo info = PersonInfo.of(PersonRole.GROOM, "first", "last", "phone", null);
        assertThat(info.getIsDeceased()).isFalse();
    }

    @Test
    void themeStyle_shouldSetDefaults() {
        ThemeStyle style = ThemeStyle.of(
                ThemeFontFamily.OWNGLYPH,
                ThemeFontSize.LARGER,
                ThemeColor.IVORY,
                ThemePattern.CHECK,
                null,
                null
        );
        assertThat(style.getDisableZoom()).isFalse();
        assertThat(style.getEnableScrollEffect()).isFalse();
    }

    @Test
    void transportationGuide_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> TransportationGuide.of(null, "desc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void weddingDate_shouldSetDefaults() {
        WeddingDate date = WeddingDate.of(LocalDateTime.now(), null, null);
        assertThat(date.getDisplayCalendar()).isTrue();
        assertThat(date.getDisplayDDay()).isTrue();
    }

    @Test
    void weddingPlace_shouldSetDefaults() {
        WeddingPlace place = WeddingPlace.of("name", "desc", "addr", null, null);
        assertThat(place.getShowMap()).isTrue();
        assertThat(place.getPlaceMapType()).isNull();
    }
}
