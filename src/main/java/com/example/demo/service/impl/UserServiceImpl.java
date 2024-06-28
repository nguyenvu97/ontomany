package com.example.demo.service.impl;

import com.example.demo.Specification.UserSpecs;
import com.example.demo.dto.UserDto;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.EntityBt.User;
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
    private final UserMapper userMapper;

    @Override
    public UserDto add(User user) {
        userRepository.save(user);
        return userMapper.entityDto(user);
    }

    @Override
    public List<UserDto> searchUser(UserDto userDto) {
        Specification<User> spec = UserSpecs.searchUser(userDto);
        List<User> users = userRepository.findAll(spec);
        return users.stream()
                .map(userMapper::entityDto)
                .collect(Collectors.toList());
    }
}
