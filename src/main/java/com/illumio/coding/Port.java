package com.illumio.coding;

/**
 * Created by jayavardhanpatil on 1/27/20
 */
public class Port {

    private int startRange;
    private int endRange;

    public Port(String port){
        String[] ports = port.split("-");
        if(ports.length > 1){
            startRange = Integer.parseInt(ports[0]);
            endRange = Integer.parseInt(ports[1]);
        }
        else{
            startRange = Integer.parseInt(ports[0]);
            endRange = Integer.parseInt(ports[0]);
        }
    }

    public boolean isValidPortRange(Port port){
        return port.startRange >= this.startRange && port.endRange <= this.endRange;
    }

}
