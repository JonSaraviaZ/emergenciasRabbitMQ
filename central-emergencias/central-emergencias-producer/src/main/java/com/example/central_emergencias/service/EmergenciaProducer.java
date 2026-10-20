package com.example.central_emergencias.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import com.example.central_emergencias.config.centralEmergenciaConfig;

@Service
public class EmergenciaProducer {

    private final RabbitTemplate rabbitTemplate;

    public EmergenciaProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void enviarEvento(String evento) {
        rabbitTemplate.convertAndSend(centralEmergenciaConfig.EVENTOS_EXCHANGE, "",evento);
        System.out.println("Mensaje enviado: " + evento);
    }

}
