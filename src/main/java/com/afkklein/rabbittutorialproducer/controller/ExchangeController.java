package com.afkklein.rabbittutorialproducer.controller;

import com.afkklein.rabbittutorialproducer.domain.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
