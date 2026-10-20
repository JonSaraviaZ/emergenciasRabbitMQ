package com.example.central_emergencias.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.central_emergencias.service.EmergenciaProducer;

@RestController 
@RequestMapping ("/emergencia-eventos")
public class EmergenciaEventos {

    private final EmergenciaProducer evento;

    public EmergenciaEventos(EmergenciaProducer evento) {
        this.evento = evento;
    }

    @PostMapping
    public String enviarEvento(@RequestBody String evento) {
        this.evento.enviarEvento(evento);
        return "Mensaje enviado";
    }
}
