package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "account_details")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountDetailEntity extends BaseEntity {
    private String ownerName;
    private String bankName;
    private String accountNumber;
    private boolean kakaoPayEnabled;

    @ManyToOne
    @JoinColumn(name = "account_group_id")
    private AccountGroupEntity accountGroup;
}
