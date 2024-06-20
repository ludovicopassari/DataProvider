package com.core.DataProvider.device;

import com.core.DataProvider.sensor.Sensor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "devices")
public class Device {

    @Id
    private String deviceId;
    private String name;
    private String type;
    private String location;
    private String userId;
    @DBRef
    private List<Sensor> sensorsId;

    public Device() {
        this.sensorsId = new ArrayList<Sensor>();
    }

    public Device(String name, String type, String userId,String location, List<Sensor> sensors) {
        this.name = name;
        this.type = type;
        this.userId = userId;
        this.location = location;
        this.sensorsId = sensors;

    }

    public String getId() {
        return deviceId;
    }

    public void setId(String id) {
        this.deviceId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sensor> getSensors() {
        return sensorsId;
    }

    public void setSensors(List<Sensor> sensors) {
        this.sensorsId = sensors;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
