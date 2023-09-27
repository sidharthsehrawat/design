package com.design.design.controller;

import com.design.design.entity.InterfaceDevice;
import com.design.design.entity.SmartHomeDevice;
import com.design.design.exception.InvalidCommand;
import com.design.design.service.CommandService;
import com.design.design.service.InterfaceService;
import com.design.design.service.SmartHomeDeviceService;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class CommandController {
    private InterfaceService interfaceService;
    private SmartHomeDeviceService smartHomeDeviceService;

    private CommandService commandService;

    public CommandController(InterfaceService interfaceService, SmartHomeDeviceService smartHomeDeviceService, CommandService commandService){
        this.interfaceService = interfaceService;
        this.smartHomeDeviceService = smartHomeDeviceService;
        this.commandService = commandService;
    }

    // execute commands

    public String executeCommand(String interfaceCommand , String deviceName, String location , String operation){
        // check if command is valid or not.
        commandvalidator(interfaceCommand,deviceName);
        String message = commandService.executeCommand(interfaceCommand,deviceName,location,operation);
        return message;
    }

    private boolean commandvalidator(String interfaceCommand , String deviceName) {
        ConcurrentHashMap<String , List<InterfaceDevice>> map  = interfaceService.getMapStrore();
        ConcurrentHashMap<String , List<SmartHomeDevice>> map2  = smartHomeDeviceService.getMapStrore();
        try{
            if(!map.containsKey(interfaceCommand) || !map2.containsKey(deviceName)){
                throw new InvalidCommand("Device Not present");
            } else{
                 // check for exact case...
            }
        }catch (InvalidCommand invalidCommand){

        }

       return true;
    }
}
