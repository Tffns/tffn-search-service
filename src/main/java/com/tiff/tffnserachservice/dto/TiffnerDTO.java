package com.tiff.tffnserachservice.dto;

import com.tiff.tffnserachservice.model.BusinessHours;
import com.tiff.tffnserachservice.model.ContactInformation;
import com.tiff.tffnserachservice.model.Reviews;
import com.tiff.tffnserachservice.model.Tags;
import lombok.Data;

import java.util.Set;

@Data
public class TiffnerDTO {

    private String name;

    private String address;

    private ContactInformation contactInformation;

    private Set<Tags> tags;

    private Set<Reviews> reviews;

    private BusinessHours businessHours;

    private String description;

    private String rating;

    private int price;


}
