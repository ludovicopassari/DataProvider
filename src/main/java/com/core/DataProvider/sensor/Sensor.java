package com.core.DataProvider.sensor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "sensors")
public class Sensor {

    @Id
    private String id;
    private String name;
    private List<SensorCapabilities> capabilities;

    public Sensor() {}

    public Sensor(String id, String name, List<SensorCapabilities> capabilities) {
        this.id = id;
        this.name = name;
        this.capabilities = capabilities;
    }

    // Getters and setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SensorCapabilities> getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(List<SensorCapabilities> capabilities) {
        this.capabilities = capabilities;
    }
}