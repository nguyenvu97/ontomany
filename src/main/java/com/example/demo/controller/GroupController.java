package com.example.demo.controller;

import com.example.demo.dto.GroupDto;
import com.example.demo.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/group")
@RequiredArgsConstructor
public class GroupController {
    public final GroupService groupService;

    @PostMapping
    public ResponseEntity<?> createGroup(@RequestBody GroupDto group) {
        return ResponseEntity.ok().body(groupService.add(group));
    }
    @GetMapping
    public ResponseEntity<?> getAllGroups(@RequestParam long id) {
        return ResponseEntity.ok().body(groupService.fingbyId(id));
    }
    @GetMapping("/findByDetails")
    public ResponseEntity<?> findByDetails(@RequestParam long id ,@RequestParam long companyId,@RequestParam long departmanetId) {
        return ResponseEntity.ok().body(groupService.findByDetails(id,companyId,departmanetId));
    }


}
