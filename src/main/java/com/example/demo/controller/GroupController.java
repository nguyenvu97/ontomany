package com.example.demo.controller;

import com.example.demo.dto.GroupDto;
import com.example.demo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/group")
@RequiredArgsConstructor
public class GroupController {
    public final GroupService groupService;

    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody GroupDto group) {
        return ResponseEntity.ok().body(groupService.add(group));
    }

}
