// package com.example.central_emergencias.controller;

// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.bind.annotation.RequestBody;


// @RestController 
// @RequestMapping ("/emergencia-eventos")
// public class EmergenciaEventos {

//     private final EventoRabbit evento;

//     public EmergenciaEventos(EventoRabbit evento) {
//         this.evento = evento;
//     }

//     @PostMapping
//     public String enviarEvento(@RequestParam String evento) {
//         evento.enviarEvent(evento);
//         return "Mensaje enviado";
    
//     }
// }
