package com.chaitu.springboot.batterymanagement.controllers;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaitu.springboot.batterymanagement.entities.BatteryData;
import com.chaitu.springboot.batterymanagement.repositories.UnknownMethod;
import com.chaitu.springboot.batterymanagement.repositories.UnknownMethodInterface;
import com.chaitu.springboot.batterymanagement.services.BatteryDataService;

@RestController
@RequestMapping("/batterydata")
public class BatteryDataController {
	
	@Autowired
	private UnknownMethodInterface  method;

	
	@Autowired
	private BatteryDataService batteryDataService;
	
	@GetMapping("/")
	public List<BatteryData> getAll(){
		
		List<BatteryData> details=batteryDataService.findAll();
		System.out.println(details.get(0).getDatetime());
		
		return details;
	}
	
	@PostMapping("/")
	public BatteryData save(@RequestBody BatteryData batteryData) {
		BatteryData savedDetails=null;
		try {
			savedDetails=batteryDataService.save(batteryData);
		} catch (Exception e) {
			
		}
		
		return savedDetails;
	}
	
	@GetMapping("/{batteryid}")
	public List<BatteryData> findById(@PathVariable("batteryid") long batteryid){
		
		List<BatteryData> details=batteryDataService.findBybatteryid(batteryid);
		return details;
	}
	
	@GetMapping("/{batteryid}/{variable2}")
	public List<Map<String,Object>> findByGiven(@PathVariable("batteryid") long batteryid,@PathVariable("variable2") String variable){
		
		List<Map<String,Object>> details=method.findByGiven(batteryid,variable);
		
		
		return details;
	}
	
	@PostMapping("/{batteryid}/{variable}/datetime")
	public List<Map<String,Object>> findByGivenTime(@PathVariable("batteryid") long batteryid,@PathVariable("variable") String variable,@RequestBody  Map<String,LocalDateTime> datetimedata){
				List<Map<String,Object>> details=method.findByGivenTime(batteryid,variable,datetimedata.get("startdatetime"),datetimedata.get("enddatetime"));
		return details;
	}
	
	
}
