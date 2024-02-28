package com.chaitu.springboot.batterymanagement.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaitu.springboot.batterymanagement.entities.BatteryManufacture;
import com.chaitu.springboot.batterymanagement.services.BatteryManufactureService;

@RestController
@RequestMapping("/batterymanufacture")
public class BatteryManufactureController {
	
	@Autowired
	private BatteryManufactureService batteryManufactureService;
	
	@PostMapping("/")
	public BatteryManufacture save(@RequestBody BatteryManufacture batteryManufacture) {
			BatteryManufacture battery=null;
			try {
				battery = batteryManufactureService.save(batteryManufacture);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}
		
		
		return battery;
	}
	
	@GetMapping("/")
	public List<BatteryManufacture> findAllDetails(){
		List<BatteryManufacture> details=batteryManufactureService.findAll();
		
		return details;
	}

}
