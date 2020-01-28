package com.illumio.coding;

import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;

import java.io.*;
import java.util.*;

/**
 * Created by jayavardhanpatil on 1/27/20
 */

public class Firewall {

    List<Rule> rules = new ArrayList<>();

    public Firewall(String filepath) throws IOException {
        readFile(filepath);
    }

    private void readFile(String filepath) throws IOException {

        /*ColumnPositionMappingStrategy strategy = new ColumnPositionMappingStrategy();
        strategy.setType(Rule.class);
        String[] columns = new String[]{"direction", "protocol", "port", "ip_address"};
        strategy.setColumnMapping(columns);
        CsvToBean csv = new CsvToBean();
        CSVReader csvReader = new CSVReader(new FileReader(filepath));
        List ruless = csv.parse(strategy, csvReader);
        for (Object object : ruless) {
            rules.add((Rule) object);
        }*/

        BufferedReader reader = new BufferedReader(new FileReader(filepath));
        String line = "";
        while ((line = reader.readLine())!=null){
            String[] dataPackets = line.split(",");
            rules.add(new Rule(dataPackets[0], dataPackets[1], dataPackets[2], dataPackets[3]));
        }
    }

    public boolean accept_packet(String direction, String protocol, int port, String ip_address) {
        Rule rule = new Rule(direction, protocol, String.valueOf(port), ip_address);
        for (Rule value : rules) {
            if (rule.isValid(value)) {
                return true;
            }
        }
        return false;
    }
}
