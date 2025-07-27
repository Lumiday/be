package com.lumiday.jpa.entity;

import com.lumiday.core.enums.AccountDesignType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "account_infos")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountInfoEntity extends BaseEntity {
    private String title;

    private String content;
    private AccountDesignType designType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groom_account_group_id")
    private AccountGroupEntity groomAccountGroup;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bride_account_group_id")
    private AccountGroupEntity brideAccountGroup;
}
