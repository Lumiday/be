package com.lumiday.springboot.core.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class InvitationDomain {
    private UserDomain user;
    private IntroLayoutDomain introLayout;
    private ThemeDomain theme;
    private PersonBaseInfoDomain personBaseInfo;
    private WeddingDateDomain weddingDate;
    private WeddingPlaceDomain weddingPlace;
    private InvitationMessageDomain invitationMessage;

    public static InvitationDomain of(UserDomain user,
                                      IntroLayoutDomain introLayout,
                                      ThemeDomain theme,
                                      PersonBaseInfoDomain personBaseInfo,
                                      WeddingDateDomain weddingDate,
                                      WeddingPlaceDomain weddingPlace,
                                      InvitationMessageDomain invitationMessage) {
        return new InvitationDomain(user, introLayout, theme, personBaseInfo, weddingDate, weddingPlace,
                invitationMessage);
    }

}
