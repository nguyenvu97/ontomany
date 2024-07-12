package com.example.demo.Thread;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;



@Component
@RequiredArgsConstructor
public class ThreadTest2 implements Callable<String> {

//    private final GroupRepository groupRepository;

    @Override
    public String call() throws Exception {
        return "ananananananananananananananananananan";
    }
}
