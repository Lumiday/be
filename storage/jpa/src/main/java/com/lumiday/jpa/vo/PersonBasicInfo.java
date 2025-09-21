package com.lumiday.jpa.vo;

import com.lumiday.core.enums.DeceasedDisplayType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PersonBasicInfo {

    @Column(name = "person_deceased_display_type")
    private DeceasedDisplayType deceasedDisplayType;

    @ElementCollection
    @CollectionTable(
            name = "person_infos",
            joinColumns = @JoinColumn(name = "invitation_id")
    )
    private List<PersonInfo> personInfos;

    public PersonBasicInfo(DeceasedDisplayType deceasedDisplayType, List<PersonInfo> personInfos) {
        if (deceasedDisplayType == null) {
            throw new IllegalArgumentException("deceasedDisplayType은 필수입니다.");
        }
        this.deceasedDisplayType = deceasedDisplayType;
        this.personInfos = personInfos == null ? List.of() : List.copyOf(personInfos);
    }
}
