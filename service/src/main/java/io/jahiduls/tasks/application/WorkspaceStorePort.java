package io.jahiduls.tasks.application;

import io.jahiduls.tasks.core.Workspace;

import java.util.List;

public interface WorkspaceStorePort {
    void save(Workspace workspace);
    Workspace fetch(String uuid);
    List<Workspace> fetchAll();
}
