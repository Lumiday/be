package com.lumiday.jpa.vo;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class WeddingDate {

    @Column(name = "wedding_date_time")
    private LocalDateTime weddingDateTime;

    @Column(name = "wedding_display_calendar")
    private Boolean displayCalendar;

    @Column(name = "wedding_display_dday")
    private Boolean displayDDay;

    public static WeddingDate of(LocalDateTime weddingDateTime, Boolean displayCalendar, Boolean displayDDay) {
        if (weddingDateTime == null) {
            throw new IllegalArgumentException("weddingDateTime은 필수입니다.");
        }
        WeddingDate date = new WeddingDate();
        date.weddingDateTime = weddingDateTime;
        date.displayCalendar = (displayCalendar != null) ? displayCalendar : Boolean.TRUE;
        date.displayDDay = (displayDDay != null) ? displayDDay : Boolean.TRUE;
        return date;
    }
}
