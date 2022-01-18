package io.jahiduls.tasks.application.resources;

public record BoardDto(String uuid, String workspaceId,
                       String name,
                       String description) {
}
