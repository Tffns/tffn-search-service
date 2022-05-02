package com.tiff.tffnserachservice.dto;

import com.tiff.tffnserachservice.model.BusinessHours;
import com.tiff.tffnserachservice.model.ContactInformation;
import lombok.Data;

import java.util.List;

@Data
public class TiffnerDTO {

    private String name;

    private String address;

    private ContactInformation contactInformation;

    private List<String> tags;

    private List<String> reviews;

    private BusinessHours businessHours;

    private String description;

    private String rating;

    private double price;



}
