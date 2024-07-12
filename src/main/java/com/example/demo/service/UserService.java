package com.example.demo.service;

import com.example.demo.dto.SearchRequestDto;
import com.example.demo.dto.UserDto;
import com.example.demo.model.EntityBt.Customer;
import com.example.demo.projection.UserDetailProjection;

import java.util.List;

public interface UserService {
    UserDto add (Customer user, long departmentId);
    List<UserDto> searchUser(SearchRequestDto searchRequestDto);
    UserDto updateUser(UserDto userDto, long departmentId);
    UserDto findById(long id);
    String deleteById(long id);
    UserDetailProjection findById1(long id);
}
