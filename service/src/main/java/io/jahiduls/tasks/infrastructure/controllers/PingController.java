package io.jahiduls.tasks.infrastructure.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    @GetMapping("/ping")
    public String healthCheck() {
        return "OK";
    }

    @GetMapping("/deep-ping")
    public String deepHealthCheck() {
        return "OK";
    }

}
