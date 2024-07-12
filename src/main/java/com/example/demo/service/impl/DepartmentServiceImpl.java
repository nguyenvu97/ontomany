package com.example.demo.service.impl;

import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.EntityBt.Department;
import com.example.demo.projection.DepartmentDetails;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.DepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final UserRepository userRepository;
    private final DepartmentMapper departmentMapper;

    // todo
    @Override
    public Department add(Department department) {
        return   departmentRepository.save(department);
//        return departmentMapper.entityDto(department);
    }

    @Override
    public List<DepartmentDetails> findById(Long id) {
        return departmentRepository.findByDepartmentId(id);
    }
}
