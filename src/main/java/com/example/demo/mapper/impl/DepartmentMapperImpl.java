package com.example.demo.mapper.impl;

import com.example.demo.dto.DepartmentDto;
import com.example.demo.mapper.DepartmentMapper;
import com.example.demo.model.EntityBt.Department;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DepartmentMapperImpl implements DepartmentMapper {

    @Override
    public DepartmentDto entityDto(Department department) {
        DepartmentDto departmentDto = new DepartmentDto();
        BeanUtils.copyProperties(department,departmentDto);
        return departmentDto;
    }

    @Override
    public Department dtoEntity(DepartmentDto departmentDto) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentDto, department);

        return department;
    }
}
