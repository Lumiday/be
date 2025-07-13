package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "wedding_dates")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeddingDateEntity extends BaseEntity {
    @OneToOne(fetch = FetchType.LAZY)
    private InvitationEntity invitation;

    private LocalDateTime weddingDateTime;
    private Boolean displayCalendar;
    private Boolean displayDDay;

    private WeddingDateEntity(InvitationEntity invitation, LocalDateTime weddingDateTime, Boolean displayCalendar,
                              Boolean displayDDay) {
        this.invitation = invitation;
        this.weddingDateTime = weddingDateTime;
        this.displayCalendar = displayCalendar;
        this.displayDDay = displayDDay;
    }

    public static WeddingDateEntity of(InvitationEntity invitation, LocalDateTime weddingDateTime,
                                       Boolean displayCalendar, Boolean displayDDay) {
        return new WeddingDateEntity(invitation, weddingDateTime, displayCalendar, displayDDay);
    }
}
