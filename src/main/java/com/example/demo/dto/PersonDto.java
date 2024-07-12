package com.example.demo.dto;

import com.example.demo.model.Address;
import com.example.demo.model.InfoPerson;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = false)
public class PersonDto extends  PageDto{

    private String firstName;
    private String lastName;
    private Address address;
    private InfoPerson infoPerson;
    private int age;
    private String GameName;
}
