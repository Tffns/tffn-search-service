package com.tiff.tffnserachservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;

@Getter
@Setter
@Embeddable
public class BusinessHours {
    public DayOfWeek startDay;
    public DayOfWeek endDay;
    public Time startTime;
    public Time endTime;

}
