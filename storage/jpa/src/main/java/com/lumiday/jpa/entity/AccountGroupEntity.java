package com.lumiday.jpa.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "account_groups")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountGroupEntity extends BaseEntity {
    private String groupName;

    @OneToMany(mappedBy = "accountGroup", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AccountDetailEntity> accountDetails = new ArrayList<>();

    public static AccountGroupEntity of(String groupName, List<AccountDetailEntity> accountDetails) {
        return new AccountGroupEntity(groupName, accountDetails);
    }
}
