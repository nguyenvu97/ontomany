package com.example.demo;

import com.example.demo.model.EntityBt.Group;
import com.example.demo.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Callable;



@Component
@RequiredArgsConstructor
public class ThreadTest2 implements Callable<List<Group>> {

    private final GroupRepository groupRepository;

    @Override
    public List<Group> call() throws Exception {
        return groupRepository.findAll();
    }
}
