package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SearchRequestDto {
    public String firstName;
    public String lastName;
    public String city;
    public String phone;
    public int age;

}
