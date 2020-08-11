package com.afkklein.rabbittutorialproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
    private Queue firstQueue;
    private Queue secondQueue;

    @Bean
    public Exchange fanoutExchange() {
        return new ExchangeBuilder("FANOUT-EXCHANGE-BASIC", ExchangeTypes.FANOUT)
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
