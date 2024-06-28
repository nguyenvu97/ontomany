package com.example.demo.service.impl;

import com.example.demo.model.Folder;
import com.example.demo.repository.FolderRepository;
import com.example.demo.service.FolderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FolderServiceImpl implements FolderService {
    public final FolderRepository folderRepository;
    @Override
    public Folder save(Folder folder) {
        return folderRepository.save(folder);
    }
}
