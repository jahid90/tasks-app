package io.jahiduls.tasks.application.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cloudevents.CloudEvent;
import io.jahiduls.tasks.application.EventBuilder;
import io.jahiduls.tasks.application.MessageQueuePort;
import io.jahiduls.tasks.application.WorkspaceStorePort;
import io.jahiduls.tasks.application.resources.WorkspaceDto;
import io.jahiduls.tasks.core.Workspace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FetchOneWorkspaceUseCase {

    private static final String EVENT_TYPE = "OneWorkspaceFetched";
    private static final String ROUTING_KEY = "tasks.workspace.fetched.one";

    private final EventBuilder eventBuilder;
    private final WorkspaceStorePort store;
    private final MessageQueuePort queue;

    public WorkspaceDto run(final String id) throws JsonProcessingException {
        final Workspace workspace = store.fetchByRefId(id);

        final CloudEvent event = eventBuilder.build(EVENT_TYPE).withPayload(workspace);
        queue.dispatch(event, ROUTING_KEY);

        return WorkspaceDto.fromWorkspace(workspace);
    }

}
