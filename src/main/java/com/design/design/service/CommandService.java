package com.design.design.service;

import com.design.design.entity.InterfaceDevice;
import com.design.design.entity.SmartHomeDevice;
import com.design.design.exception.InvalidCommand;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommandService {

    private InterfaceService interfaceService ;
    private SmartHomeDeviceService smartHomeDeviceService;

    public CommandService(SmartHomeDeviceService smartHomeDeviceService,InterfaceService interfaceService){
        this.interfaceService = interfaceService;
        this.smartHomeDeviceService = smartHomeDeviceService;
    }
    public String executeCommand(String interfaceCommand, String deviceName, String location, String operation) {
        ConcurrentHashMap<String , List<InterfaceDevice>> interfaceServiceMapStrore =  interfaceService.getMapStrore();
        boolean flag = false;
        for(Map.Entry<String , List<InterfaceDevice>> entry : interfaceServiceMapStrore.entrySet()){
            for(InterfaceDevice interfaceDevice : entry.getValue()){
                if(interfaceDevice.getLocation().equalsIgnoreCase(location) ){
                    flag= true;
                   break;
                }
            }
        }

        ConcurrentHashMap<String , List<SmartHomeDevice>> smartHomeDeviceServicemap =  smartHomeDeviceService.getMapStrore();
 boolean flag2 = false;


        for(Map.Entry<String , List<SmartHomeDevice>> entry : smartHomeDeviceServicemap.entrySet()){
            for(SmartHomeDevice smartHomeDevice : entry.getValue()){
                if(smartHomeDevice.getDevicename().equalsIgnoreCase(deviceName) || smartHomeDevice.getLocation().equalsIgnoreCase(location)){
                    flag= true;
                    break;
                }
            }
        }

        if(flag && flag2){
         List<SmartHomeDevice> deviceList  =  smartHomeDeviceServicemap.get(  smartHomeDeviceServicemap.get(deviceName));
         for(SmartHomeDevice smartHomeDevice : deviceList){
            if(smartHomeDevice.getDevicename().equalsIgnoreCase(deviceName)){
                smartHomeDevice.setStatus(operation);
            }
         }
        }else{
            try{
                throw new InvalidCommand("Operation Not supported");
            }catch (InvalidCommand invalidCommand){}
            System.out.println("throw exception");
        }


        return "Executed Successfully";

    }

}
