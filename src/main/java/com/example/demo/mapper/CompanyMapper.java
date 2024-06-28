package com.example.demo.mapper;

import com.example.demo.dto.CompanyDto;
import com.example.demo.model.EntityBt.Company;

public interface CompanyMapper {
    CompanyDto entityDto(Company company);
    Company dtoEntity(CompanyDto companyDto);
}
