package io.jahiduls.tasks.application.events;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.builder.CloudEventBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EventBuilder {

    private static final String EVENT_SOURCE = "tasks-event-builder";

    private final CloudEventBuilder builder;
    private final ObjectMapper sedes;

    public EventBuilder build(final String eventType) {

        builder.withId(UUID.randomUUID().toString())
                .withSource(URI.create(EVENT_SOURCE))
                .withType(eventType);

        return this;
    }

    public CloudEvent withPayload(final Object payload) throws JsonProcessingException {
        return builder.withData(sedes.writeValueAsBytes(payload))
                .build();
    }

}
