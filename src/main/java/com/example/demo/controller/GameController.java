package com.example.demo.controller;

import com.example.demo.model.Game;
import com.example.demo.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/game")
@RequiredArgsConstructor
public class GameController {
    public final GameService gameService;

    @PostMapping
    public ResponseEntity<String> startGame(@RequestBody Game game) {
        return ResponseEntity.ok().body(gameService.add(game));
    }
}
