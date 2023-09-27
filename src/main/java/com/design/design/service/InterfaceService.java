package com.design.design.service;

import com.design.design.entity.InterfaceDevice;
import com.design.design.exception.DeviceAlreadyExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class InterfaceService {
    // in -mem database Store

    ConcurrentHashMap <String , List<InterfaceDevice>> interfaceMapStore = new ConcurrentHashMap<>();
    public InterfaceDevice addInterface(InterfaceDevice interfaceDevice) {
         if(!interfaceMapStore.containsKey(interfaceDevice.getName())){
              List<InterfaceDevice> interfaceDeviceList = new ArrayList<>();
              interfaceDeviceList.add(interfaceDevice);
             interfaceMapStore.put(interfaceDevice.getName(),interfaceDeviceList);
         }else {
             for(InterfaceDevice interfaceDevice1 : interfaceMapStore.get(interfaceDevice.getName())){
                 try{
                     if(interfaceDevice1.getLocation().equalsIgnoreCase(interfaceDevice.getLocation())){
                         throw new DeviceAlreadyExistException("Interface Already Added At that Location");
                     }
                 }catch (DeviceAlreadyExistException exception){
                     System.out.println("Exception Caught");
                     exception.printStackTrace();
                 }
             }
             List<InterfaceDevice> interfaceDeviceList = interfaceMapStore.get(interfaceDevice.getName());
             interfaceDeviceList.add(interfaceDevice);
             interfaceMapStore.put(interfaceDevice.getName(),interfaceDeviceList);

         }
         return interfaceDevice;
    }

    public List<String> getAllInterfaceDevices() {
        List<String> interfaceDeviceList = new ArrayList<>();
        for(Map.Entry<String , List<InterfaceDevice>> entry : interfaceMapStore.entrySet()){
            interfaceDeviceList.add(entry.getKey());
        }
        return interfaceDeviceList;
    }

    //JPA Data
    public  ConcurrentHashMap <String , List<InterfaceDevice>> getMapStrore (){
        return interfaceMapStore;
    }

}
