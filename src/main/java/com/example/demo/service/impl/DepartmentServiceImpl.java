package com.example.demo.service.impl;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.EntityBt.Department;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final DepartmentMapper departmentMapper;

    @Override
    public Department add(Department department) {
        return   departmentRepository.save(department);
//        return departmentMapper.entityDto(department);
    }
}
