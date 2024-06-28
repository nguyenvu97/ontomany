package com.example.demo.dto;

import lombok.Data;

import java.util.List;

@Data

public class GroupDto {
    private long id;
    private String groupName;
    public List<CompanyDto> companyDtos;
}
