package com.afkklein.rabbittutorialproducer.config;

import lombok.AllArgsConstructor;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AllArgsConstructor
public class FanoutConfig {
    private final Queue firstQueue;
    private final Queue secondQueue;

    @Bean
    public Exchange fanoutExchange() {
        return ExchangeBuilder
                .fanoutExchange("FANOUT-EXCHANGE-BASIC")
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstFanoutBinding() {
        return BindingBuilder
                .bind(firstQueue)
                .to(fanoutExchange())
                .with("")
                .noargs();
    }

    @Bean
    public Binding secondFanoutBinding() {
        return BindingBuilder
                .bind(secondQueue)
                .to(fanoutExchange())
                .with("")
                .noargs();
    }
}
