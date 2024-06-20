package com.core.DataProvider.device;

import com.core.DataProvider.sensor.Sensor;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

public class DeviceResponse {

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private String deviceId;
    private String name;
    private String type;
    private String location;
    private String userId;

}
