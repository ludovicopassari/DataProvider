package com.core.DataProvider.device;

import org.springframework.stereotype.Service;
import org.springframework.web.context.WebApplicationContext;

@Service
public class TaskService {

    private final WebApplicationContext webApplicationContext;

    public TaskService(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    public void performDeviceInsert(Device device) {
        CreateDeviceService task = webApplicationContext.getBean(CreateDeviceService.class);
        task.setDevice(device);
        Thread thread = new Thread(task);
        thread.start();

    }
}
