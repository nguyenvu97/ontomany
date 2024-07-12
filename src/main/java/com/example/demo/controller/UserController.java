package com.example.demo.controller;

import com.example.demo.dto.SearchRequestDto;
import com.example.demo.dto.UserDto;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUser(@RequestBody SearchRequestDto searchRequestDto) {
        return ResponseEntity.ok().body(userService.searchUser(searchRequestDto));
    }
    @PutMapping
    public ResponseEntity<?> update(@RequestBody UserDto userDto, @RequestParam long departmentId) {
        return ResponseEntity.ok().body(userService.updateUser(userDto,departmentId));
    }
    @GetMapping("findById")
    public ResponseEntity<?> findById(@RequestParam long id) {
        return ResponseEntity.ok().body(userService.findById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<?> add(@RequestBody UserDto userDto, @RequestParam long departmentId) {
        return ResponseEntity.ok().body(userService.add(userDto,departmentId));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<?> delete( @RequestParam long userId) {
        return ResponseEntity.ok().body(userService.deleteById(userId));
    }
    @GetMapping("newFindById")
    public ResponseEntity<?> findBy(@RequestParam long id){
        System.out.println(id);
        return ResponseEntity.ok().body(userService.findById1(id));
    }


}
