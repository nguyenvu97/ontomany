package com.example.demo.model;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;

@Embeddable
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address implements Serializable {
    private String street;
    private String city;
    private String state;
    private String zipCode;
}
