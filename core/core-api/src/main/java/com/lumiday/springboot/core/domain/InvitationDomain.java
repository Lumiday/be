package com.lumiday.springboot.core.domain;

import com.lumiday.core.enums.DeceasedDisplayType;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InvitationDomain {
    private UserDomain user;
    private IntroLayoutDomain introLayout;
    private ThemeDomain theme;
    private List<PersonInfoDomain> personInfoList;
    private DeceasedDisplayType deceasedDisplayType;
    private WeddingDateDomain weddingDate;
    private WeddingPlaceDomain weddingPlace;
    private InvitationMessageDomain invitationMessage;

    public static InvitationDomain of(UserDomain user, IntroLayoutDomain introLayout, ThemeDomain theme,
                                      List<PersonInfoDomain> personInfoList, DeceasedDisplayType deceasedDisplayType,
                                      WeddingDateDomain weddingDate, WeddingPlaceDomain weddingPlace,
                                      InvitationMessageDomain invitationMessage) {
        return new InvitationDomain(user, introLayout, theme, personInfoList, deceasedDisplayType, weddingDate,
                weddingPlace, invitationMessage);
    }
}
