package com.example.demo.Thread.MultiThread;

import java.util.Map;

public interface CharacterCountingService {
    Map<Character, Long> count(String dir);

    long getExecutedTimeInNanos();
}
