package com.design.design.controller;

import com.design.design.entity.InterfaceDevice;
import com.design.design.service.InterfaceService;
import java.util.*;

public class InterfaceController {

    private InterfaceService interfaceService;

    public InterfaceController(InterfaceService interfaceService){
        this.interfaceService = interfaceService;
    }

    public InterfaceDevice addInterfaceDevice(InterfaceDevice interfaceDevice){
       return interfaceService.addInterface(interfaceDevice);
    }

    public List<String> getAllInterfaceDevices(){
       return interfaceService.getAllInterfaceDevices();
    }

}
