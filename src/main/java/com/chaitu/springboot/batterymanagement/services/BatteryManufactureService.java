package com.chaitu.springboot.batterymanagement.services;

import java.util.List;

import com.chaitu.springboot.batterymanagement.entities.BatteryManufacture;

public interface BatteryManufactureService {
	
	public BatteryManufacture save(BatteryManufacture batteryManufacture);
	
	public BatteryManufacture findById(long id);
	public List<BatteryManufacture> findAll();
	public List<BatteryManufacture> findByBatteryid(long batteryid);

}
