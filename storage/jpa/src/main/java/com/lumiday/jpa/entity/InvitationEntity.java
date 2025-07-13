package com.lumiday.jpa.entity;

import com.lumiday.core.enums.DeceasedDisplayType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "invitations")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class InvitationEntity extends BaseEntity {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @OneToOne(mappedBy = "invitation")
    private IntroLayoutEntity introLayout;

    @OneToOne(mappedBy = "invitation")
    private ThemeStyleEntity theme;

    @OneToMany(mappedBy = "invitation", fetch = FetchType.LAZY)
    private List<PersonInfoEntity> personInfoList;

    @Enumerated(EnumType.STRING)
    private DeceasedDisplayType deceasedDisplayType;

    private InvitationEntity(UserEntity user, DeceasedDisplayType deceasedDisplayType) {
        this.user = user;
        this.deceasedDisplayType = deceasedDisplayType;
    }

    public static InvitationEntity of(UserEntity user, DeceasedDisplayType deceasedDisplayType) {
        return new InvitationEntity(user, deceasedDisplayType);
    }
}
