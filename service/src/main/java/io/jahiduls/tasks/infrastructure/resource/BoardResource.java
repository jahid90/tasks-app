package io.jahiduls.tasks.infrastructure.resource;

public record BoardResource(String uuid, String workspaceId,
                            String name,
                            String description) {
}
