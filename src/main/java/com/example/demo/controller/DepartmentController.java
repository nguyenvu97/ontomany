package com.example.demo.controller;

import com.example.demo.model.EntityBt.Department;
import com.example.demo.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/department")
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<?> addDepartment(@RequestBody Department department) {
        return ResponseEntity.ok().body(departmentService.add(department));
    }
    @GetMapping
    public ResponseEntity<?> findById(@RequestParam Long id) {
        return ResponseEntity.ok().body(departmentService.findById(id));
    }
}
