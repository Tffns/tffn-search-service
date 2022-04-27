package com.tiff.tffnserachservice.model;

import lombok.Data;

import javax.persistence.Embeddable;

@Data
@Embeddable
public class ContactInformation {
    public String phoneNumber;
    public String emailAddress;

}
