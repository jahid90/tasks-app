package io.jahiduls.tasks.application.resources;

import io.jahiduls.tasks.core.Workspace;

import java.util.UUID;

public record WorkspaceDto(String uuid,
                           String name,
                           String description) {

    public static WorkspaceDto fromWorkspace(final Workspace workspace) {
        return new WorkspaceDto(workspace.refId(), workspace.name(), workspace.description());
    }

    public Workspace toWorkspace() {
        return new Workspace(UUID.randomUUID().toString(), uuid, name, description);
    }
}
