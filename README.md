# Projeto MessageProducer

Este projeto demonstra como enviar mensagens para um tópico do Kafka usando Spring Boot.

## Funcionalidades:

Envia mensagens para um tópico do Kafka através de uma API REST.

## Tecnologias:

Spring Boot (versão 3.1.9)

Kafka

Springdoc OpenApi (versão 2.3.0)

## Dependências:

Spring Web Starter (spring-boot-starter-web)

Spring Kafka (spring-kafka)

Spring Boot Starter Test (spring-boot-starter-test) (para testes unitários)

Spring Kafka Test (spring-kafka-test) (para testes unitários específicos do Kafka)

### Como usar:

Pré-requisitos: Certifique-se de ter o Java 17 instalado.

#### Construir e executar:
> mvn clean install 

> mvn spring-boot:run

Acessar API:
A aplicação é executada na porta 8082.

A documentação da Swagger UI está disponível em http://localhost:8082/swagger-ui.html.

Enviar mensagem:
Use o método POST no endpoint /enviar-mensagem com um corpo JSON contendo a mensagem.

#### Exemplo de requisição:

> curl -X POST \
-H "Content-Type: application/json" \
-d '{"mensagem":"Mensagem de teste"}' \

http://localhost:8082/enviar-mensagem

#### Exemplo de resposta:

Mensagem enviada com sucesso para o Kafka!