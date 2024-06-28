package com.example.demo.service;

import com.example.demo.dto.UserDto;
import com.example.demo.model.EntityBt.User;

import java.util.List;

public interface UserService {
    UserDto add (User user);
    List<UserDto> searchUser(UserDto userDto);
}
