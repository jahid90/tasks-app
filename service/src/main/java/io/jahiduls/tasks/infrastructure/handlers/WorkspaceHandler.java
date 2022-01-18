package io.jahiduls.tasks.infrastructure.handlers;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.jahiduls.tasks.application.usecases.CreateWorkspaceUseCase;
import io.jahiduls.tasks.application.usecases.FetchWorkspacesUseCase;
import io.jahiduls.tasks.application.resources.WorkspaceDto;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class WorkspaceHandler {

    private final CreateWorkspaceUseCase createWorkspaceUseCase;
    private final FetchWorkspacesUseCase fetchWorkspacesUseCase;

    public void handleCreate(@NonNull final WorkspaceDto input) throws JsonProcessingException {
        createWorkspaceUseCase.run(input.toWorkspace());
    }

    public List<WorkspaceDto> handleFetchAll() throws JsonProcessingException {
        return fetchWorkspacesUseCase.run().stream().map(WorkspaceDto::fromWorkspace).collect(Collectors.toList());
    }

}
