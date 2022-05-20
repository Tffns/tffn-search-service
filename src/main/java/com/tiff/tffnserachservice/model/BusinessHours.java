package com.tiff.tffnserachservice.model;

import lombok.*;

import javax.persistence.Embeddable;
import java.sql.Time;
import java.time.DayOfWeek;


@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class BusinessHours {
    public DayOfWeek startDay;
    public DayOfWeek endDay;
    public Time startTime;
    public Time endTime;

}
