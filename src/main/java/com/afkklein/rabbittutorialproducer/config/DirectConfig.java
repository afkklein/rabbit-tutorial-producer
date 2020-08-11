package com.afkklein.rabbittutorialproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {
    private static final Queue firstQueue = new AnonymousQueue();
    private static final Queue secondQueue = new AnonymousQueue();
    private static final Queue jsonQueue = new AnonymousQueue();

    @Bean
    public Exchange directExchange() {
        return new ExchangeBuilder("DIRECT-EXCHANGE-BASIC", ExchangeTypes.DIRECT)
                .durable(true)
                .build();
    }

    @Bean
    public Binding firstDirectBinding() {
        return BindingBuilder
                .bind(firstQueue)
                .to(directExchange())
                .with("TO-FIRST-QUEUE")
                .noargs();
    }

    @Bean
    public Binding secondDirectBinding() {
        return BindingBuilder
                .bind(secondQueue)
                .to(directExchange())
                .with("TO-SECOND-QUEUE")
                .noargs();
    }

    @Bean
    public Binding jsonDirectBinding() {
        return BindingBuilder
                .bind(jsonQueue)
                .to(directExchange())
                .with("TO-JSON-QUEUE")
                .noargs();
    }
}
