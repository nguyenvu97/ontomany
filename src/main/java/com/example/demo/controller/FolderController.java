package com.example.demo.controller;

import com.example.demo.model.Folder;
import com.example.demo.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/folder")
@RequiredArgsConstructor
public class FolderController {
    public final FolderService folderService;

    @PostMapping
    public ResponseEntity<?>add(@RequestBody Folder folder){
        return ResponseEntity.ok(folderService.save(folder));
    }
}
