package io.jahiduls.tasks.application;

import io.jahiduls.tasks.core.Workspace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkspaceService {

    private final WorkspaceStorePort store;

    public void persistWorkspace(final Workspace workspace) {
        store.save(workspace);
    }

    public Workspace retrieveWorkspaceWithId(final String uuid) {
        return store.fetch(uuid);
    }

}
