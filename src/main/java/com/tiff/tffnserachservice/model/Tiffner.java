package com.tiff.tffnserachservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tffn")
@Builder
public class Tiffner {
    /*
        TODO:
            10. thumbnail -  Byte
     */

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long tiffnerId;

    private String name;

    @Embedded
    private ContactInformation contactInformation;

    private String address;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name ="tiffner_id")
    private Set<Tags> tags;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinColumn(name="tiffner_id")
    private Set<Reviews> reviews;

    @Embedded
    private BusinessHours businessHours;

    private String description;

    private String rating;

    private int price;

}
