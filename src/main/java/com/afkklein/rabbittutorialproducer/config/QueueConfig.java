package com.afkklein.rabbittutorialproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {
    @Bean
    public Queue firstQueue() {
        return QueueBuilder
                .durable("FIRST-QUEUE-BASIC")
                .build();
    }

    @Bean
    public Queue secondQueue() {
        return QueueBuilder
                .durable("SECOND-QUEUE-BASIC")
                .build();
    }

    @Bean
    public Queue jsonQueue() {
        return QueueBuilder
                .durable("JSON-QUEUE-BASIC")
                .build();
    }
}
