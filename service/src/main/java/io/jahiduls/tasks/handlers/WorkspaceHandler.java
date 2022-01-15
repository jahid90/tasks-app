package io.jahiduls.tasks.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cloudevents.CloudEvent;
import io.cloudevents.core.v1.CloudEventBuilder;
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

    private static final String EVENT_SOURCE = "tasks-workspace-handler";
    private static final String EVENT_TYPE = "tasks-event";

    private final ObjectMapper mapper;

    public void createWorkspace(final WorkspaceResource resource) throws JsonProcessingException {
        final CloudEvent createWorkspaceEvent = new CloudEventBuilder().newBuilder()
                .withId(UUID.randomUUID().toString())
                .withSource(URI.create(EVENT_SOURCE))
                .withType(EVENT_TYPE)
                .withData(mapper.writeValueAsBytes(resource))
                .build();

        log.info("Sending message: {}", createWorkspaceEvent);

        // Send to rabbitMQ
    }

}
