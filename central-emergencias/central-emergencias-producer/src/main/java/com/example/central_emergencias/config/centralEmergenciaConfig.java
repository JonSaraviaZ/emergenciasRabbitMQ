package com.example.central_emergencias.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;

@Configuration 
public class centralEmergenciaConfig {

    public static final String EVENTOS_EXCHANGE ="eventos_fanout_exchange";
    public static final String POLICIA_CONSUMER= "policia_consumer";

    public static final String BOMBEROS_CONSUMER= "bomberos_consumer";

    @Bean 
    public FanoutExchange eventosExchange() {
        return new FanoutExchange(EVENTOS_EXCHANGE); 
    }

    @Bean
    public Queue policiaQueue() {
        return new Queue(POLICIA_CONSUMER, false);
    }

    @Bean
    public Queue bomberosQueue() {
        return new Queue(BOMBEROS_CONSUMER, false);
    }

    @Bean
    public Binding policiaBinding() {
        return BindingBuilder
                .bind(policiaQueue())
                .to(eventosExchange());
    }

    @Bean
    public Binding bomberosBinding() {
        return BindingBuilder
                .bind(bomberosQueue())
                .to(eventosExchange());
    }


}
