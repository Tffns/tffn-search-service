package com.tiff.tffnserachservice.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="test")
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
        11. id - generated
        TODO:
            10. thumbnail -  Byte
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long tiffnerId;

    public String name;

    @Embedded
    public ContactInformation contactInformation;

    public String address;

    @ElementCollection
    public List<String> tags;

    @ElementCollection
    public List<String> reviews;

    @Embedded
    private BusinessHours businessHours;

    public String description;

    public String rating;

    public int price;

}
