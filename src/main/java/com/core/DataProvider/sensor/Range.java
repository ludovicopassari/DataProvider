package com.core.DataProvider.sensor;

public class Range {
    private String min;
    private String max;

    public Range(String min, String max) {
        this.min = min;
        this.max = max;
    }

    public Range() {}

    public String getMin() {
        return min;
    }

    public void setMin(String min) {
        this.min = min;
    }

    public String getMax() {
        return max;
    }

    public void setMax(String max) {
        this.max = max;
    }


}
