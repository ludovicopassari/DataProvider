package com.core.DataProvider.sensor;

public class AddSensorRequest {
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String deviceId) {
        this.sensorId = deviceId;
    }

    private String sensorId;
}
