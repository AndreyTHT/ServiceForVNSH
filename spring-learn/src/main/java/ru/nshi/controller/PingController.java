package ru.nshi.controller;

import ru.nshi.enums.PingStatus;
import ru.nshi.model.Ping;
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
