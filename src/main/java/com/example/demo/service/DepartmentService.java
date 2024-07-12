package com.example.demo.service;

import com.example.demo.model.EntityBt.Department;
import com.example.demo.projection.DepartmentDetails;

import java.util.List;

public interface DepartmentService {

    Department add (Department department);

   List<DepartmentDetails> findById(Long id);
}
