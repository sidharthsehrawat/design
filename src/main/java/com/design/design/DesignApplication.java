package com.design.design;

import com.design.design.controller.CommandController;
import com.design.design.controller.InterfaceController;
import com.design.design.controller.SmartHomeDevicesController;
import com.design.design.entity.InterfaceDevice;
import com.design.design.entity.SmartHomeDevice;
import com.design.design.service.CommandService;
import com.design.design.service.InterfaceService;
import com.design.design.service.SmartHomeDeviceService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

public class DesignApplication {

	public static void main(String[] args) {

		InterfaceController interfaceController = new InterfaceController(new InterfaceService());

		interfaceController.addInterfaceDevice(new InterfaceDevice("Google Home", "Drawing Room" , "OK Google"));
		interfaceController.addInterfaceDevice(new InterfaceDevice("Alexa", "Drawing Room" , "Alexa"));
		interfaceController.addInterfaceDevice(new InterfaceDevice("Alexa", "Kitchen" , "Alexa"));


		SmartHomeDevicesController smartHomeDevicesController = new SmartHomeDevicesController(new SmartHomeDeviceService());
		smartHomeDevicesController.addSmartHomeDevice(new SmartHomeDevice("Alexa", "Light", "Kitchen","OFF"));
		smartHomeDevicesController.addSmartHomeDevice(new SmartHomeDevice("Alexa", "Fan", "Drawing Room","OFF"));
		smartHomeDevicesController.addSmartHomeDevice(new SmartHomeDevice("Alexa", "Light", "Living Room","OFF"));
		smartHomeDevicesController.addSmartHomeDevice(new SmartHomeDevice("Google Home", "Light", "Living Room", "OFF"));

		List<String> getallsamrtHoemDevices = smartHomeDevicesController.getAllSmartHomeDevices();
		System.out.println(getallsamrtHoemDevices);

		CommandController commandController = new CommandController(new InterfaceService(), new SmartHomeDeviceService(),
				new CommandService(new SmartHomeDeviceService(),new InterfaceService()));
		String message = commandController.executeCommand("Alexa" , "Light","Kitchen","ON");
		String message2 = commandController.executeCommand("Google" , "Light","Kitchen","ON");
		System.out.println(message2);

		String message3 = commandController.executeCommand("Alexa" , "Light","Kitchen","ON");
		System.out.println(message3);
		String message4 = commandController.executeCommand("Alexa" , "Light","Kitchen","ON");
		System.out.println(message4);
		String message5 = commandController.executeCommand("Alexa" , "Light","Kitchen","ON");
		System.out.println(message5);
		String message6 = commandController.executeCommand("Alexa" , "Fan","Kitchen","ON");
		System.out.println("" + message6);


	}

}
