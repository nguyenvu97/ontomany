package com.example.demo.service.impl;

import com.example.demo.model.Game;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {
    private final GameRepository gameRepoSitory;
    @Override
    public String add(Game game) {
        gameRepoSitory.save(game);
        return "Ok";
    }
}
