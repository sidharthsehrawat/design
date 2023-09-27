package com.design.design.controller;

import com.design.design.entity.SmartHomeDevice;
import com.design.design.service.SmartHomeDeviceService;

import java.util.List;

public class SmartHomeDevicesController {
    private SmartHomeDeviceService smartHomeDeviceService;
    public SmartHomeDevicesController(SmartHomeDeviceService smartHomeDeviceService){
        this.smartHomeDeviceService = smartHomeDeviceService;
    }

    public SmartHomeDevice addSmartHomeDevice(SmartHomeDevice smartHomeDevice){
      return smartHomeDeviceService.addHomeDevice(smartHomeDevice);
    }

    public List<String> getAllSmartHomeDevices(){
        return smartHomeDeviceService.getAllSmartHomeDevices();
    }

}
