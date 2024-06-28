package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data

public class DepartmentDto {
    private String name;
    private List<UserDto> users;
    private CompanyDto companyDto;
}
