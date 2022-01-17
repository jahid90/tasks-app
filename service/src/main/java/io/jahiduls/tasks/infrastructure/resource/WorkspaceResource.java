package io.jahiduls.tasks.infrastructure.resource;

import io.jahiduls.tasks.core.Workspace;

import java.util.UUID;

public record WorkspaceResource(String uuid,
                                String name,
                                String description) {

    public static WorkspaceResource fromWorkspace(final Workspace workspace) {
        return new WorkspaceResource(workspace.refId(), workspace.name(), workspace.description());
    }

    public Workspace toWorkspace() {
        return new Workspace(UUID.randomUUID().toString(), uuid, name, description);
    }
}
