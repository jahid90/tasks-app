package io.jahiduls.tasks.infrastructure.store;

import io.jahiduls.tasks.application.WorkspaceStorePort;
import io.jahiduls.tasks.core.Workspace;
import org.springframework.stereotype.Service;

@Service
public class NullStoreAdapter implements WorkspaceStorePort {

    @Override
    public void save(Workspace workspace) {
        return;
    }

    @Override
    public Workspace fetch(String uuid) {
        return null;
    }
    
}
