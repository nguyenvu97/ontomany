package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.EntityBt.Customer;


public  interface UserMapper {

    UserDto entityDto(Customer user);
    Customer dtoEntity(UserDto userDto);
}
