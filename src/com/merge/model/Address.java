package com.merge.model;

public class Address {
    private String ip;
    private int port;

    public Address(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public Address setIp(String ip) {
        this.ip = ip;
        return this;
    }

    public Address setPort(int port) {
        this.port = port;
        return this;
    }
}
