package io.jahiduls.tasks.resource;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class BoardResource {

    private final String uuid;
    private final String workspaceId;
    private final String name;
    private final String description;

}
