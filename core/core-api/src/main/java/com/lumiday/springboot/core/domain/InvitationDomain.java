package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;
import lombok.Getter;

@Getter
public class InvitationDomain {
    UserDomain user;
    IntroLayoutDomain introLayout;
    ThemeDomain theme;
    List<PersonInfoDomain> personInfoList;
    DeceasedDisplayType deceasedDisplayType;
    WeddingDateDomain weddingDate;
    WeddingPlaceDomain weddingPlace;

    private InvitationDomain(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme,
                             List<PersonInfoDomain> personInfoList, DeceasedDisplayType deceasedDisplayType,
                             WeddingDateDomain weddingDate, WeddingPlaceDomain weddingPlace) {
        this.user = user;
        this.introLayout = introLayout;
        this.theme = theme;
        this.personInfoList = personInfoList;
        this.deceasedDisplayType = deceasedDisplayType;
        this.weddingDate = weddingDate;
        this.weddingPlace = weddingPlace;
    }

    public static InvitationDomain of(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme,
                                      List<PersonInfoDomain> personInfoList, DeceasedDisplayType deceasedDisplayType,
                                      WeddingDateDomain weddingDate, WeddingPlaceDomain weddingPlace) {
        return new InvitationDomain(user, introLayout, theme, personInfoList, deceasedDisplayType, weddingDate,
                weddingPlace);
    }
}
