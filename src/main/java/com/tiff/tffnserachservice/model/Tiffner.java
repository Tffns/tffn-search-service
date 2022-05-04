package com.tiff.tffnserachservice.model;

import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tffn")
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name ="tiffner_id")
    private Set<Tags> tags;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name="tiffner_id")
    private Set<Reviews> reviews;

    @Embedded
    private BusinessHours businessHours;

    private String description;

    private String rating;

    private int price;

}
