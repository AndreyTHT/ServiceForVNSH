package org.example.controller;

import org.example.enums.PingStatus;
import org.example.model.Ping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ping")
public class PingController {

    @GetMapping
    public Ping getStatus() {
        return new Ping(PingStatus.UP);
    }
}
