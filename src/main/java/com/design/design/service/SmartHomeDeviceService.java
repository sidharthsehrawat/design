package com.design.design.service;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import com.design.design.entity.InterfaceDevice;
import com.design.design.entity.SmartHomeDevice;
import com.design.design.exception.DeviceAlreadyExistException;

public class SmartHomeDeviceService {

    ConcurrentHashMap<String,List<SmartHomeDevice>> smartHomeDataStore = new ConcurrentHashMap<>();

    public SmartHomeDevice addHomeDevice(SmartHomeDevice smartHomeDevice) {
        if(!smartHomeDataStore.containsKey(smartHomeDevice.getInterfaceName())){
            List<SmartHomeDevice> smartHomeDeviceList = new ArrayList<>();
            smartHomeDeviceList.add(smartHomeDevice);
            smartHomeDataStore.put(smartHomeDevice.getInterfaceName(),smartHomeDeviceList);
        }else {
            for(SmartHomeDevice SmartHomeDevice1 : smartHomeDataStore.get(smartHomeDevice.getInterfaceName())){
                try{
                    if(SmartHomeDevice1.getLocation().equalsIgnoreCase(smartHomeDevice.getLocation())){
                        throw new DeviceAlreadyExistException("Home Device Already Added At that Location");
                    }
                }catch (DeviceAlreadyExistException exception){
                    System.out.println("Home Device Already Added At that Location");
                    exception.printStackTrace();
                }
            }
            List<SmartHomeDevice> smartHomeDeviceList = smartHomeDataStore.get(smartHomeDevice.getInterfaceName());
            smartHomeDeviceList.add(smartHomeDevice);
            smartHomeDataStore.put(smartHomeDevice.getInterfaceName(),smartHomeDeviceList);

        }
        return smartHomeDevice;
    }

    public List<String> getAllSmartHomeDevices() {
        List<String> smartHomeDeviceList = new ArrayList<>();
        for(Map.Entry<String , List<SmartHomeDevice>> entry : smartHomeDataStore.entrySet()){
            smartHomeDeviceList.add(entry.getKey());
        }
        return smartHomeDeviceList;
    }

    public  ConcurrentHashMap <String , List<SmartHomeDevice>> getMapStrore (){
        return smartHomeDataStore;
    }

}
