package io.jahiduls.tasks.application;

import io.jahiduls.tasks.core.Workspace;

public interface WorkspaceStorePort {
    void save(Workspace workspace);
    Workspace fetch(String uuid);
}
