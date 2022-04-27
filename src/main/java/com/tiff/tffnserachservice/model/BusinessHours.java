package com.tiff.tffnserachservice.model;

import lombok.Data;

import javax.persistence.Embeddable;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;

@Data
@Embeddable
public class BusinessHours {
    public DayOfWeek startDay;
    public DayOfWeek endDay;
    public Time startTime;
    public Time endTime;

}
