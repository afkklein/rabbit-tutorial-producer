package com.afkklein.rabbittutorialproducer.controller;

import com.afkklein.rabbittutorialproducer.domain.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("exchanges")
public class ExchangeController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private Logger log = LoggerFactory.getLogger(ExchangeController.class);

    @PostMapping("{exchange}/{routingKey}")
    public HttpEntity<?> postOnExchange(@PathVariable String exchange, @PathVariable String routingKey, @RequestBody String message) {
        log.info("Sending message " + message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }

    @PostMapping("json/{exchange}/{routingKey}")
    public HttpEntity<?> postJsonOnExchange(@PathVariable String exchange, @PathVariable String routingKey, @RequestBody Person message) {
        log.info("sending message " + message);
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        return ResponseEntity.ok().build();
    }

}
