package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data
public class CompanyDto {
    private long id;
    private String companyName;
    public List<DepartmentDto> department;
    private GroupDto groupDto;
}
