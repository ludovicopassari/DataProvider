package com.core.DataProvider.sensor;

public class SensorCapabilities {

    private String type;
    private String unit;
    private String accuracy;
    private String resolution;
    private  Range range;

    public SensorCapabilities(){}

    public SensorCapabilities(String type, String unit, String accuracy, String resolution, Range range) {
        this.type = type;
        this.unit = unit;
        this.accuracy = accuracy;
        this.resolution = resolution;
        this.range = range;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public Range getRange() {
        return range;
    }

    public void setRange(Range range) {
        this.range = range;
    }
}
