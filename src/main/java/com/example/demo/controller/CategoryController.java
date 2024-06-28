package com.example.demo.controller;

import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/category")
@RequiredArgsConstructor
public class CategoryController {
    public final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<?>add(){
        return ResponseEntity.ok(categoryService.addNew());
    }

    @GetMapping
    public ResponseEntity<?>add( @RequestParam int Id){
        return ResponseEntity.ok(categoryService.findById(Id));
    }

}
