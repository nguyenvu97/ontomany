package com.example.demo.mapper.impl;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.model.EntityBt.Company;
import com.example.demo.model.EntityBt.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GroupMapperImpl  implements GroupMapper {
    private final CompanyMapper companyMapper;
    @Override
    public GroupDto entityDto(Group group) {
        GroupDto groupDto = new GroupDto();
        BeanUtils.copyProperties(group, groupDto);
        List<CompanyDto> groupDtos = new ArrayList<>();
        for (Company company : group.getCompanies()){
            CompanyDto companyDto = companyMapper.entityDto(company);
            groupDtos.add(companyDto);
        }
        groupDto.setCompanyDtos(groupDtos);
        return groupDto;
    }
    @Override
    public Group dtoEntity(GroupDto groupDto) {
        Group group = new Group();

        BeanUtils.copyProperties(groupDto, group);

        List<Company> companies = new ArrayList<>();
        for (CompanyDto companyDto : groupDto.getCompanyDtos()) {
            Company company = companyMapper.dtoEntity(companyDto);
            companies.add(company);
        }
        group.setCompanies(companies);

        return group;
    }

}
