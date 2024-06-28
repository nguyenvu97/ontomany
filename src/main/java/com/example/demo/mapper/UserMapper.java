package com.example.demo.mapper;

import com.example.demo.dto.UserDto;
import com.example.demo.model.EntityBt.User;

public interface UserMapper {
    UserDto entityDto(User user);
    User dtoEntity(UserDto userDto);
}
