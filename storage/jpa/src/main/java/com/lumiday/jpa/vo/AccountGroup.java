package com.lumiday.jpa.vo;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class AccountGroup {

    @Column(name = "account_group_name")
    private String name;

    @ElementCollection
    @CollectionTable(
            name = "account_details",
            joinColumns = @JoinColumn(name = "invitation_id")
    )
    private List<AccountDetail> accountDetails = new ArrayList<>();

    public AccountGroup(String name, List<AccountDetail> accountDetails) {
        if (name == null) {
            throw new IllegalArgumentException("그룹 이름은 필수입니다.");
        }
        this.name = name;
        this.accountDetails = (accountDetails != null) ? accountDetails : new ArrayList<>();
    }
}
