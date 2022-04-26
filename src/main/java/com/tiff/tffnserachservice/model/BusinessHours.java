package com.tiff.tffnserachservice.model;

import lombok.Data;

import java.sql.Time;
import java.time.DayOfWeek;
import java.util.Date;

@Data
public class BusinessHours {
    public DayOfWeek startDay;
    public DayOfWeek endDay;
    public Time startTime;
    public Time endTime;

}
