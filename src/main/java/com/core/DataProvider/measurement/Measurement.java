package com.core.DataProvider.measurement;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "misurazioni")
public class Measurement {
    @Id
    private String id;
    private String tipoMisurazione;
    private String valore;
    private String fromSensor;
    private String fromDevice;
    private String timestamp;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipoMisurazione() {
        return tipoMisurazione;
    }

    public void setTipoMisurazione(String tipoMisurazione) {
        this.tipoMisurazione = tipoMisurazione;
    }

    public String getValore() {
        return valore;
    }

    public void setValore(String valore) {
        this.valore = valore;
    }

    public String getFromSensor() {
        return fromSensor;
    }

    public void setFromSensor(String fromSensor) {
        this.fromSensor = fromSensor;
    }

    public String getFromDevice() {
        return fromDevice;
    }

    public void setFromDevice(String fromDevice) {
        this.fromDevice = fromDevice;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

}
