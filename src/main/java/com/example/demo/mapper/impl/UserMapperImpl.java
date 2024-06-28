package com.example.demo.mapper.impl;

import com.example.demo.dto.CompanyDto;
import com.example.demo.dto.DepartmentDto;
import com.example.demo.dto.GroupDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.CompanyMapper;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.mapper.GroupMapper;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.EntityBt.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserMapperImpl implements UserMapper {
    private final DepartmentMapper departmentMapper;
    private final CompanyMapper companyMapper;
    private final GroupMapper groupMapper;


    @Override
    public UserDto entityDto(User user) {
        UserDto userDto = new UserDto();
       DepartmentDto departmentDto  = departmentMapper.entityDto(user.getDepartment());
        userDto.setDepartmentName(departmentDto.getName());
        CompanyDto companyDto = companyMapper.entityDto(user.getDepartment().getCompany());
        userDto.setCompanyName(companyDto.getCompanyName());
        GroupDto groupDto = groupMapper.entityDto(user.getDepartment().getCompany().getGroup());
        userDto.setGroupName(groupDto.getGroupName());
        BeanUtils.copyProperties(user,userDto);
        return userDto;
    }

    @Override
    public User dtoEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto,user);
        return user;
    }
}
