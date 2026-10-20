package com.example.central_emergencias.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.example.central_emergencias.config.centralEmergenciaConfig;


@Service
public class AmbulanciaConsumer {

    @RabbitListener(queues = centralEmergenciaConfig.AMBULANCIA_CONSUMER)
    public void recibir(String message) {
        System.out.println("AMBULANCIA recibió: " + message);
    }
}
