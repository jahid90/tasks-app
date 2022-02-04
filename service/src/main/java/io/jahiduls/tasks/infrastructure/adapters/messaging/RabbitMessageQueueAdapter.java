package io.jahiduls.tasks.infrastructure.adapters.messaging;

import io.cloudevents.CloudEvent;
import io.cloudevents.core.provider.EventFormatProvider;
import io.cloudevents.jackson.JsonFormat;
import io.jahiduls.tasks.application.ports.MessageQueuePort;
import io.jahiduls.tasks.infrastructure.configs.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitMessageQueueAdapter implements MessageQueuePort {

    private final RabbitMQConfig rabbitConfig;

    @Override
    public void dispatch(CloudEvent event, final String routingKey) {

        // Serialize the cloud event
        final byte[] serialized = EventFormatProvider.getInstance()
                .resolveFormat(JsonFormat.CONTENT_TYPE)
                .serialize(event);

        // Send to rabbitMQ
        rabbitConfig.getRabbitTemplate().convertAndSend(routingKey, serialized);
    }

}
