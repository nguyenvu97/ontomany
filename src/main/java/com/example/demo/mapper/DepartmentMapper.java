package com.example.demo.mapper;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.model.EntityBt.Department;

public interface DepartmentMapper {
    DepartmentDto entityDto(Department department);
    Department dtoEntity(DepartmentDto departmentDto);
}
