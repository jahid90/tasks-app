package io.jahiduls.tasks.application.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cloudevents.CloudEvent;
import io.jahiduls.tasks.application.events.EventBuilder;
import io.jahiduls.tasks.application.ports.MessageQueuePort;
import io.jahiduls.tasks.application.ports.WorkspaceStorePort;
import io.jahiduls.tasks.core.Workspace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateWorkspaceUseCase {

    private static final String EVENT_TYPE = "WorkspaceCreated";
    private static final String ROUTING_KEY = "tasks.workspace.created";

    private final EventBuilder eventBuilder;
    private final WorkspaceStorePort store;
    private final MessageQueuePort queue;

    public void run(final Workspace workspace) throws JsonProcessingException {
        store.save(workspace);

        final CloudEvent event = eventBuilder.build(EVENT_TYPE).withPayload(workspace);
        queue.dispatch(event, ROUTING_KEY);
    }

}
