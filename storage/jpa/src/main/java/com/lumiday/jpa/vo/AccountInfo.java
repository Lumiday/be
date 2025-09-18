package com.lumiday.jpa.vo;

import com.lumiday.core.enums.AccountDesignType;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountInfo {

    @Column(name = "account_title")
    private String title;

    @Column(name = "account_content")
    private String content;

    @Column(name = "account_design_type")
    @Enumerated(EnumType.STRING)
    private AccountDesignType designType;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "groom_group_name"))
    private AccountGroup groomAccountGroup;

    @Embedded
    @AttributeOverride(name = "name", column = @Column(name = "bride_group_name"))
    private AccountGroup brideAccountGroup;

    public static AccountInfo of(String title, String content, AccountDesignType designType,
                                 AccountGroup groomAccountGroup, AccountGroup brideAccountGroup) {
        if (title == null || content == null || designType == null) {
            throw new IllegalArgumentException("title, content, designType는 필수입니다.");
        }

        AccountInfo info = new AccountInfo();
        info.title = title;
        info.content = content;
        info.designType = designType;
        info.groomAccountGroup = (groomAccountGroup != null) ? groomAccountGroup : AccountGroup.of("", List.of());
        info.brideAccountGroup = (brideAccountGroup != null) ? brideAccountGroup : AccountGroup.of("", List.of());
        return info;
    }
}
