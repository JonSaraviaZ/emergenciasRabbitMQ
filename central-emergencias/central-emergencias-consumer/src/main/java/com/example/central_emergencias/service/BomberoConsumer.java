package com.example.central_emergencias.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import com.example.central_emergencias.config.centralEmergenciaConfig;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service 
public class BomberoConsumer {

    @RabbitListener(queues = centralEmergenciaConfig.BOMBEROS_CONSUMER)
    public void recibir(String message) {
        try {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode evento = mapper.readTree(message);

        System.out.println(
            "BOMBEROS recibió: "
            + evento.get("tipo").asText() + " | "
            + evento.get("ubicacion").asText() + " | "
            + evento.get("descripcion").asText()
        );

    } catch (Exception e) {
        System.err.println("Error al procesar el evento: " + e.getMessage());
    }
    }

}
