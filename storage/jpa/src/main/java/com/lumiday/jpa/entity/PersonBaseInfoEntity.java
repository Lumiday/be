package com.lumiday.jpa.entity;

import com.lumiday.core.enums.DeceasedDisplayType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "person_base_informations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonBaseInfoEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private DeceasedDisplayType deceasedDisplayType;

    @OneToMany(mappedBy = "personBaseInfo", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PersonInfoEntity> personInfoList = new ArrayList<>();

    public static PersonBaseInfoEntity of(DeceasedDisplayType deceasedDisplayType) {
        return new PersonBaseInfoEntity(deceasedDisplayType, new ArrayList<>());
    }

    public void addPersonInfo(PersonInfoEntity entity) {
        personInfoList.add(entity);
    }
}
