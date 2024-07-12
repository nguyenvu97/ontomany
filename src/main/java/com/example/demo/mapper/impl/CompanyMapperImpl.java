package com.example.demo.mapper.impl;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.EntityBt.Company;
import com.example.demo.model.EntityBt.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor

public class CompanyMapperImpl  implements CompanyMapper {
    private final DepartmentMapper departmentMapper;
    @Override
    public CompanyDto entityDto(Company company) {
        CompanyDto companyDto = new CompanyDto();
        List<DepartmentDto> departmentList = new ArrayList<>();
        for (Department department : company.getDepartmentList()){

            departmentList.add(departmentMapper.entityDto(department));
        }
         companyDto.setDepartment(departmentList);

        BeanUtils.copyProperties(company, companyDto);
        return companyDto;
    }

    @Override
    public Company dtoEntity(CompanyDto companyDto) {
        Company company = new Company();
        BeanUtils.copyProperties(companyDto, company);

        List<Department> departmentList = new ArrayList<>();
        for (DepartmentDto departmentDto : companyDto.getDepartment()) {
            Department department = departmentMapper.dtoEntity(departmentDto);
            departmentList.add(department);
        }
        company.setDepartmentList(departmentList);

        return company;
    }
}
