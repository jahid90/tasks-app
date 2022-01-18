package io.jahiduls.tasks.infrastructure.adapters.store;

import io.jahiduls.tasks.application.WorkspaceStorePort;
import io.jahiduls.tasks.core.Workspace;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@Service
public class InMemoryStoreAdapter implements WorkspaceStorePort {

    private final Map<String, Workspace> store = new HashMap<>();

    @Override
    public void save(Workspace workspace) {
        store.put(workspace.id(), workspace);
    }

    @Override
    public Workspace fetch(String uuid) {
        return store.get(uuid);
    }

    @Override
    public Workspace fetchByRefId(String id) {
        return store.values()
                .stream()
                .filter(it -> it.refId().equals(id))
                .findFirst()
                .orElseThrow(NoSuchElementException::new);
    }

    @Override
    public List<Workspace> fetchAll() {
        return store.values().stream().toList();
    }

}
