package com.example.demo.mapper.impl;

import com.example.demo.dto.UserDto;
import com.example.demo.mapper.MapperTogether;
import com.example.demo.model.EntityBt.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component

@Slf4j
public class UserMapperImpl implements MapperTogether<Customer,UserDto> {




    @Override
    public UserDto entityDto(Customer user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setAddress(user.getAddress());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setCreatedBy(user.getCreatedBy());
        userDto.setUpdatedBy(user.getUpdatedBy());
        userDto.setDepartmentName(user.getDepartment().getName());
//        userDto.setCompanyName(user.getDepartment().getCompany().getCompanyName());
//        userDto.setGroupName(user.getDepartment().getCompany().getGroup().getGroupName());

        return userDto;
    }


    @Override
    public Customer dtoEntity(UserDto userDto) {
        return null;
    }
}
