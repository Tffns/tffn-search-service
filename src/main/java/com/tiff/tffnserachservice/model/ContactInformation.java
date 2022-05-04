package com.tiff.tffnserachservice.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Getter
@Setter
@Embeddable
public class ContactInformation {
    public String phoneNumber;
    public String emailAddress;

}
