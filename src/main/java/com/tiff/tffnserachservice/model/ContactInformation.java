package com.tiff.tffnserachservice.model;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
@Builder

public class ContactInformation {
    public String phoneNumber;
    public String emailAddress;

}
