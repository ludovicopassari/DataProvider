package com.core.DataProvider.device;

import com.core.DataProvider.measurement.MeasuramentRepository;
import com.core.DataProvider.measurement.Measurement;

import com.core.DataProvider.sensor.Sensor;
import com.core.DataProvider.sensor.SensorRepository;
import com.mongodb.client.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.Query;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    Logger logger = Logger.getLogger(DeviceController.class.getName());

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    SensorRepository sensorRepository;
    @Autowired
    private MongoClient mongo;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Autowired
    MeasuramentRepository measuramentRepository;

    @GetMapping("/measurement/{idDevice}")
    public Measurement getMeasurement(@PathVariable String idDevice) {
        return measuramentRepository.findByFromDeviceOrderByTimestampDesc(idDevice).get(0);

    }

    @GetMapping("/get/{userId}")
    public List<Device> responsetest( @PathVariable String userId) {
        Optional<List<Device>> devices =  deviceRepository.findDeviceByUserId(userId);
        return devices.get();
    }


    @PostMapping
    public Device createDevice(@RequestBody Device device) {
        return deviceRepository.save(device);
    }

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable String id) {
        Optional<Device> device = deviceRepository.findByDeviceId(id);
        if (device.isPresent()) {
            return ResponseEntity.ok().body(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Device>> getDeviceByUserId(@PathVariable String userId) {
        Optional<List<Device>> devices =  deviceRepository.findDeviceByUserId(userId);
        if (devices.isPresent()) {
            return ResponseEntity.ok().body(devices.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/addSensor/{deviceId}/{sensorId}")
    public ResponseEntity<Device> addSensorToDevice(@PathVariable String deviceId, @PathVariable String sensorId) {
        // Trova il dispositivo per ID
        Optional<Device> optionaldevice = deviceRepository.findById(deviceId);
        Device device =   optionaldevice.get();

        // Verifica se il sensore esiste
        Optional<Sensor> optionalsensor = sensorRepository.findById(sensorId);
        Sensor sensor = optionalsensor.get();

        // Aggiungi l'ID del sensore alla lista di sensori del dispositivo
        device.getSensors().add(sensor);

        // Salva il dispositivo aggiornato nel repository
        deviceRepository.save(device);

        return ResponseEntity.ok().body(device);
    }

}
