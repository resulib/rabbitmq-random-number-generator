package com.resul.rabbitmqrandomnumbergenerator.controller;

import com.resul.rabbitmqrandomnumbergenerator.service.RandomNumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/random")
@RequiredArgsConstructor
public class RandomNumberController {
    private final RandomNumberService randomNumberService;

    @GetMapping("/generate")
    public ResponseEntity<String> generateRandomNumber() {
        randomNumberService.sendRandomNumber();
        return ResponseEntity.ok("Random number generated and sent to queue.");
    }
}