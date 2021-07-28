package io.jahiduls.tasks.controller;

import io.jahiduls.tasks.exceptions.NotYetImplementedException;
import io.jahiduls.tasks.resource.WorkspaceResource;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workspace")
public class WorkspaceController {

    @GetMapping("")
    public List<WorkspaceResource> fetchAllWorkspaces() {
        throw new NotYetImplementedException();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createWorkspace(@RequestBody final WorkspaceResource workspace) {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public WorkspaceResource fetchWorkspace(@PathVariable final String id) {
        throw new NotYetImplementedException();
    }

    @PutMapping("/{id}")
    public void updateWorkspace(@PathVariable final String id, @RequestBody final WorkspaceResource workspace) {
        throw new NotYetImplementedException();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteWorkspace(@PathVariable final String id) {
        throw new NotYetImplementedException();
    }

}
