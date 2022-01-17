package io.jahiduls.tasks.infrastructure.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jahiduls.tasks.application.CreateWorkspaceUseCase;
import io.jahiduls.tasks.infrastructure.resource.WorkspaceResource;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkspaceHandler {

    private final CreateWorkspaceUseCase createWorkspaceUseCase;

    public void handleCreate(@NonNull final WorkspaceResource resource) throws JsonProcessingException {
        createWorkspaceUseCase.run(resource.toWorkspace());
    }

}
