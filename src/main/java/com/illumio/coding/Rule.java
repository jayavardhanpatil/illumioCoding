package com.illumio.coding;

import java.util.Objects;

/**
 * Created by jayavardhanpatil on 1/27/20
 */

public class Rule {
    private String direction;
    private String protocol;
    private Port port;
    private IpAddress ip;

    public Rule(String direction, String protocol, String port, String ip) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = new Port(port);
        this.ip = new IpAddress(ip);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Port getPort() {
        return port;
    }

    public void setPort(Port port) {
        this.port = port;
    }

    public IpAddress getIp() {
        return ip;
    }

    public void setIp(IpAddress ip) {
        this.ip = ip;
    }

    public boolean isValid(Object o) {
        Rule rule = (Rule) o;
        return (rule.direction.equals(this.direction) &&
                rule.protocol.equals(this.protocol) &&
                rule.port.isValidPortRange(this.port) &&
                rule.ip.isValidIpInTheRange(this.ip));
    }
}
