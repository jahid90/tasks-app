package io.jahiduls.tasks.application.ports;

import io.jahiduls.tasks.core.Workspace;

import java.util.List;

public interface WorkspaceStorePort {
    void save(Workspace workspace);
    Workspace fetch(String uuid);
    Workspace fetchByRefId(String id);
    List<Workspace> fetchAll();
}
