package com.tiff.tffnserachservice.model;

import lombok.Data;

import java.time.DayOfWeek;
import java.util.Date;
import java.util.List;

@Data
public class Tiffner {
    /*
        1. Name - String
        2. Contact Information
                - phone number
                - email
        3. Location - address - String
        4. Tags - List of String
        5. Reviews - List of String
            - comments
        6. Days of Operation - DATE OBJECT FROM - UNTIL
            - Days
            - Hours
        7. Description - String
        8. Rating - List of Stars
        9. Price - 1-4 Integers
        TODO:
            10. thumbnail -  Byte
     */
    public String name;
    public ContactInformation contactInformation;
    public String address;
    public List<String> tags;
    public List<String> reviews;
    public Date daysOfOperation;
    public String description;
    public String rating;
    public int price;



}