package com.vini.messageproducerkafka.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageProducerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private KafkaTemplate<String, String> kafkaTemplate;

    @Test
    public void testEnviarMensagem() throws Exception {
        String mensagem = "Mensagem de teste";

        mockMvc.perform(MockMvcRequestBuilders.post("/enviar-mensagem")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mensagem))
                .andExpect(status().isOk())
                .andExpect(content().string("Mensagem enviada com sucesso para o Kafka!"));

        verify(kafkaTemplate).sendDefault(mensagem);
    }
}
