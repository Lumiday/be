package com.lumiday.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "wedding_dates")
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class WeddingDateEntity extends BaseEntity {
    private LocalDateTime weddingDateTime;
    private Boolean displayCalendar;
    private Boolean displayDDay;

    public static WeddingDateEntity of(LocalDateTime weddingDateTime,
                                       Boolean displayCalendar, Boolean displayDDay) {
        return new WeddingDateEntity(weddingDateTime, displayCalendar, displayDDay);
    }
}
