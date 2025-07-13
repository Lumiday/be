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

    private InvitationDomain(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme,
                             List<PersonInfoDomain> personInfoList, DeceasedDisplayType deceasedDisplayType) {
        this.user = user;
        this.introLayout = introLayout;
        this.theme = theme;
        this.personInfoList = personInfoList;
        this.deceasedDisplayType = deceasedDisplayType;
    }

    public static InvitationDomain of(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme,
                                      List<PersonInfoDomain> personInfoList, DeceasedDisplayType deceasedDisplayType) {
        return new InvitationDomain(user, introLayout, theme, personInfoList, deceasedDisplayType);
    }
}
