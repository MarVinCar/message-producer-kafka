package com.vini.messageproducerkafka.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/enviar-mensagem")
    public String enviarMensagem(@RequestBody String mensagem) {
        kafkaTemplate.sendDefault(mensagem);
        return "Mensagem enviada com sucesso para o Kafka!";
    }
}

