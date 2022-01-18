package io.jahiduls.tasks.infrastructure.controllers;

import io.jahiduls.tasks.infrastructure.exceptions.NotYetImplementedException;
import io.jahiduls.tasks.application.resources.BoardDto;
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

@RestController
@RequestMapping("/board")
public class BoardController {

    @GetMapping("")
    public List<BoardDto> fetchAllBoards(@PathParam("workspaceId") final String workspaceId,
                                         @PathParam("page") final int page) {

        throw new NotYetImplementedException();
    }

    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public void createBoard(@RequestBody final BoardDto input) {
        throw new NotYetImplementedException();
    }

    @GetMapping("/{id}")
    public BoardDto fetchBoard(@PathVariable final String id) {
        throw new NotYetImplementedException();
    }

    @PutMapping("/{id}")
    public void updateBoard(@PathVariable final String id, @RequestBody final BoardDto input) {
        throw new NotYetImplementedException();
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBoard(@PathVariable final String id) {
        throw new NotYetImplementedException();
    }

}
