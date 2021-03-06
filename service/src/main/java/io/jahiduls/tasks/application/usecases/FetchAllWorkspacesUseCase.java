package io.jahiduls.tasks.application.usecases;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.cloudevents.CloudEvent;
import io.jahiduls.tasks.application.events.EventBuilder;
import io.jahiduls.tasks.application.ports.MessageQueuePort;
import io.jahiduls.tasks.application.ports.WorkspaceStorePort;
import io.jahiduls.tasks.core.Workspace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FetchAllWorkspacesUseCase {

    private static final String EVENT_TYPE = "AllWorkspacesFetched";
    private static final String ROUTING_KEY = "tasks.workspace.fetched.all";

    private final EventBuilder eventBuilder;
    private final WorkspaceStorePort store;
    private final MessageQueuePort queue;

    public List<Workspace> run() throws JsonProcessingException {
        final List<Workspace> workspaces = store.fetchAll();

        final CloudEvent event = eventBuilder.build(EVENT_TYPE).withPayload(workspaces);
        queue.dispatch(event, ROUTING_KEY);

        return workspaces;
    }

}
