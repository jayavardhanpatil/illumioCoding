package com.illumio.coding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by jayavardhanpatil on 1/27/20
 */
public class IpAddress {

    private ArrayList<Integer> startIp = new ArrayList<>();
    private ArrayList<Integer> endIp = new ArrayList<>();

    IpAddress(String ipAddr){

            String[] ips = ipAddr.split("-");
            String[] ipNUmbers;
            if(ips.length > 1) {
                ipNUmbers = ips[0].split("\\.");
                for (String number : ipNUmbers) {
                    this.startIp.add(Integer.parseInt(number));
                }

                ipNUmbers = ips[1].split("\\.");
                for (String number : ipNUmbers) {
                    this.endIp.add(Integer.parseInt(number));
                }
            }
            else{
                ipNUmbers = ips[0].split("\\.");
                for (String number : ipNUmbers) {
                    this.endIp.add(Integer.parseInt(number));
                }
                this.startIp.addAll(endIp);
            }
        }

        public boolean isValidIpInTheRange(IpAddress ipAddress){

            for(int i=0;i<4;i++){
                if(ipAddress.startIp.get(i) < this.startIp.get(i) || ipAddress.endIp.get(i) > this.endIp.get(i)){
                    return false;
                }
            }
            return true;

        }

}
