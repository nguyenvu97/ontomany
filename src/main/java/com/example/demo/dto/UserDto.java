package com.example.demo.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String firstname;
    private String lastname;
    private String address;
    private String userName;
    private String departmentName;
    private String companyName;
    private String groupName;
}
