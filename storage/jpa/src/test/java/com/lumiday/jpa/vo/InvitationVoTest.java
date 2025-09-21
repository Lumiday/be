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
        assertThatThrownBy(() -> new AccountDetail(null, "bank", "123", true))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new AccountDetail("owner", null, "123", true))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new AccountDetail("owner", "bank", null, true))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void accountDetail_shouldSetDefaults() {
        AccountDetail ad = new AccountDetail("owner", "bank", "123", null);
        assertThat(ad.getKakaoPayEnabled()).isNull();
    }

    @Test
    void accountGroup_shouldInitializeListAndFailWithoutName() {
        assertThatThrownBy(() -> new AccountGroup(null, null)).isInstanceOf(IllegalArgumentException.class);

        AccountGroup group = new AccountGroup("group1", null);
        assertThat(group.getAccountDetails()).isNotNull().isEmpty();
    }

    @Test
    void accountInfo_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> new AccountInfo(null, "content", AccountDesignType.BASIC, null, null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void attendanceCheck_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> new AttendanceCheck(null, "content", "btn", AttendanceType.ETC))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void backgroundMusic_shouldSetDefaults() {
        BackgroundMusic bgm = new BackgroundMusic("song", null);
        assertThat(bgm.getAutoplay()).isFalse();
    }

    @Test
    void ending_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> new Ending(null, "content", "img"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void gallery_shouldSetDefaults() {
        Gallery gallery = new Gallery("name", GalleryType.CHECKERBOARD, null, null);
        assertThat(gallery.getUsePopUpView()).isFalse();
        assertThat(gallery.getImages()).isNotNull().isEmpty();
    }

    @Test
    void introLayout_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> new IntroLayout(null, PhotoFrameStyle.FRAME, "img"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void invitationMessage_shouldFailWithoutRequiredFields() {
        assertThatThrownBy(() -> new InvitationMessage(null, "content"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void personBaseInfo_shouldSetDefaults() {
        PersonBasicInfo baseInfo = new PersonBasicInfo(DeceasedDisplayType.CHRYSANTHEMUM, null);
        assertThat(baseInfo.getPersonInfos()).isEmpty();
    }

    @Test
    void personInfo_shouldSetDefaults() {
        PersonInfo info = new PersonInfo(PersonRole.GROOM, "first", "last", "phone", null);
        assertThat(info.getIsDeceased()).isFalse();
    }

    @Test
    void themeStyle_shouldSetDefaults() {
        ThemeStyle style = new ThemeStyle(
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
        assertThatThrownBy(() -> new TransportationGuide(null, "desc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void weddingDate_shouldSetDefaults() {
        WeddingDate date = new WeddingDate(LocalDateTime.now(), null, null);
        assertThat(date.getDisplayCalendar()).isTrue();
        assertThat(date.getDisplayDDay()).isTrue();
    }

    @Test
    void weddingPlace_shouldSetDefaults() {
        WeddingPlace place = new WeddingPlace("name", "desc", "addr", null, null);
        assertThat(place.getShowMap()).isTrue();
        assertThat(place.getPlaceMapType()).isNull();
    }
}
