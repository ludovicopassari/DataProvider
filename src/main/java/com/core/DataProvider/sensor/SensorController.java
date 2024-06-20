package com.core.DataProvider.sensor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sensors")
public class SensorController {

    @Autowired
    private SensorRepository sensorRepository;

    // Endpoint per aggiungere un sensore
    @PostMapping
    public Sensor addSensor(@RequestBody Sensor sensor) {
        return sensorRepository.save(sensor);
    }

    // Endpoint per ottenere tutti i sensori
    @GetMapping
    public ResponseEntity<List<Sensor>> getAllSensors() {
        return ResponseEntity.ok(sensorRepository.findAll());
    }

    // Endpoint per ottenere un sensore per id
    @GetMapping("/{id}")
    public Sensor getSensorById(@PathVariable String id) {
        return sensorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sensor not found with id: " + id));
    }

    // Endpoint per aggiornare un sensore esistente
    @PutMapping("/{id}")
    public Sensor updateSensor(@PathVariable String id, @RequestBody Sensor sensor) {
        sensor.setId(id); // Assicura che l'ID del sensore da aggiornare sia impostato correttamente
        return sensorRepository.save(sensor);
    }

    // Endpoint per eliminare un sensore
    @DeleteMapping("/{id}")
    public void deleteSensor(@PathVariable String id) {
        sensorRepository.deleteById(id);
    }
}