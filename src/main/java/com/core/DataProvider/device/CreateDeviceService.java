package com.core.DataProvider.device;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CreateDeviceService implements  Runnable{
    Logger logger = Logger.getLogger(CreateDeviceService.class.getName());
    private Device device;

    @Autowired
    private DeviceRepository deviceRepository;

    public void setDevice(Device device) {
        this.device = device;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();

        logger.info("Esecuzione inserimento Device su thread " + threadName);

        deviceRepository.save(device);

        logger.info("Inserimento Device completato su thread " + threadName);

    }
}
