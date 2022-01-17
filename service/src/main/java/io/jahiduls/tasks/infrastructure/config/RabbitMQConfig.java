package io.jahiduls.tasks.infrastructure.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@RequiredArgsConstructor
public class RabbitMQConfig {

    @Getter
    private final RabbitTemplate rabbitTemplate;

    @Setter
    @Value("${tasks.rabbitmq.exchange}")
    private String TOPIC_EXCHANGE_NAME;

    @Setter
    @Value("${tasks.rabbitmq.default-routing-key}")
    private String DEFAULT_ROUTING_KEY;

    @PostConstruct
    public void init() {
        rabbitTemplate.setExchange(TOPIC_EXCHANGE_NAME);
        rabbitTemplate.setRoutingKey(DEFAULT_ROUTING_KEY);
    }

}
