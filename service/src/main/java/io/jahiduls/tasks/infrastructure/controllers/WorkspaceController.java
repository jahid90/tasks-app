package io.jahiduls.tasks.infrastructure.controllers;

import io.jahiduls.tasks.application.resources.WorkspaceDto;
import io.jahiduls.tasks.infrastructure.exceptions.NotYetImplementedException;
import io.jahiduls.tasks.infrastructure.handlers.WorkspaceHandler;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/workspace")
public class WorkspaceController {

    private final WorkspaceHandler handler;

    @GetMapping("")
    public List<WorkspaceDto> fetchAllWorkspaces(@PathParam("page") final Optional<Integer> page) throws Exception {

        page.ifPresent(pageNum -> log.info("Looking for page number: {}", pageNum));

        return handler.handleFetchAll();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorkspace(@RequestBody @NonNull final WorkspaceDto input) throws Exception {
        handler.handleCreate(input);
    }

    @GetMapping("/{id}")
    public WorkspaceDto fetchWorkspace(@PathVariable final String id) {
        throw new NotYetImplementedException();
    }

    @PutMapping("/{id}")
    public void updateWorkspace(@PathVariable final String id, @RequestBody final WorkspaceDto input) {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkspace(@PathVariable final String id) {
        throw new NotYetImplementedException();
    }

}
