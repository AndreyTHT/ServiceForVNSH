package ru.nshi.model;

import ru.nshi.enums.PingStatus;

public class Ping {
    private PingStatus status;

    public Ping(PingStatus status) {
        this.status = status;
    }

    public PingStatus getStatus() {
        return status;
    }

    public void setStatus(PingStatus status) {
        this.status = status;
    }
}
