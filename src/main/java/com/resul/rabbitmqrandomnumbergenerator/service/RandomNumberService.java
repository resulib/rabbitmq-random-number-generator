package com.resul.rabbitmqrandomnumbergenerator.service;

import com.resul.rabbitmqrandomnumbergenerator.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
@Slf4j
public class RandomNumberService {
    private final RabbitTemplate rabbitTemplate;

    public void sendRandomNumber() {
        int randomNumber = new Random().nextInt(1000);
        rabbitTemplate.convertAndSend(RabbitMQConfig.QUEUE, randomNumber);
        log.info("Sent Random Number: {}", randomNumber);
    }
}