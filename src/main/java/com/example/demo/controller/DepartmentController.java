package com.example.demo.controller;

import com.example.demo.model.EntityBt.Department;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public ResponseEntity<?> addDepartment(Department department) {
        return ResponseEntity.ok().body(departmentService.add(department));
    }
}
