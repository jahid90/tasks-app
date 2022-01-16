package io.jahiduls.tasks.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.provider.EventFormatProvider;
import io.cloudevents.core.v1.CloudEventBuilder;
import io.cloudevents.jackson.JsonFormat;
import io.jahiduls.tasks.config.RabbitMQConfig;
import io.jahiduls.tasks.resource.WorkspaceResource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkspaceHandler {

    private static final String LOCAL_EVENT_SOURCE = "tasks-workspace-handler";
    private static final String LOCAL_ROUTING_KEY = "tasks.workspace.*";

    private final ObjectMapper sedes;
    private final RabbitMQConfig rabbitConfig;
    private final CloudEventBuilder eventBuilder;

    public void handleCreate(final WorkspaceResource resource) throws JsonProcessingException {

        // Create the cloud event
        final CloudEvent createWorkspaceEvent = eventBuilder
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create(LOCAL_EVENT_SOURCE))
                .withData(sedes.writeValueAsBytes(resource))
                .build();

        log.debug("Sending event: {}", createWorkspaceEvent);

        // Serialize the cloud event
        final byte[] serialized = EventFormatProvider.getInstance()
                .resolveFormat(JsonFormat.CONTENT_TYPE)
                .serialize(createWorkspaceEvent);

        // Send to rabbitMQ
        rabbitConfig.getRabbitTemplate().convertAndSend(LOCAL_ROUTING_KEY, serialized);
    }

}
