package com.example.demo.service.impl;

import com.example.demo.Specification.UserSpecs;
import com.example.demo.dto.SearchRequestDto;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.MapperTogether;
import com.example.demo.model.EntityBt.Department;
import com.example.demo.model.EntityBt.Customer;
import com.example.demo.projection.UserDetailProjection;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {
    public final UserRepository userRepository;
    public final DepartmentRepository departmentRepository;
    private final MapperTogether<Customer,UserDto> userMapper;

    @Override
    public UserDto add(Customer user, long departmentId) {
        Department department = departmentRepository.findById(departmentId).orElse(null);
        if (department == null) {
            return null;
        }
        return userMapper.entityDto(userRepository.save(Customer
                .builder()
                .address(user.getAddress())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .userName(user.getUserName())
                .department(department)
                .createdBy("admin")
                .updatedBy("admin")
                .build()));
    }

    @Override
    public List<UserDto> searchUser(SearchRequestDto searchRequestDto  ) {
        Specification<Customer> spec = UserSpecs.searchUser(searchRequestDto);
        List<Customer> users = userRepository.findAll(spec);
       return users.stream().map(userMapper::entityDto).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(UserDto userDto, long departmentId) {
        Customer user = userRepository.findById(userDto.getId()).orElseThrow(null);
        user.setFirstName(userDto.getFirstName());
        user.setUserName(userDto.getUserName());
        user.setAddress(userDto.getAddress());
        user.setLastName(userDto.getLastName());
       Department department =  departmentRepository.findById(departmentId).orElseThrow(null);
        user.setDepartment(department);
        userRepository.save(user);
        return userMapper.entityDto(user);
    }

    @Override
    public UserDto findById(long id) {
        Customer user = userRepository.findById(id).orElseThrow(null);
        return userMapper.entityDto(user);

    }

    @Override
    public String deleteById(long id) {
        Customer user = userRepository.findById(id).orElseThrow(null);
        userRepository.delete(user);
        return "OK";
    }

    @Override
    public UserDetailProjection findById1(long id) {
        UserDetailProjection user = userRepository.findByID(id);
        return user ;
    }


}
