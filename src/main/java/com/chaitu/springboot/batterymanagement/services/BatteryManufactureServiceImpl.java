package com.chaitu.springboot.batterymanagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaitu.springboot.batterymanagement.entities.BatteryManufacture;
import com.chaitu.springboot.batterymanagement.repositories.BatteryManufactureRepository;

@Service
public class BatteryManufactureServiceImpl implements BatteryManufactureService {
	
	@Autowired
	private BatteryManufactureRepository batteryManufactureRepository;

	@Override
	public BatteryManufacture save(BatteryManufacture batteryManufacture) {
		// TODO Auto-generated method stub
		return batteryManufactureRepository.save(batteryManufacture);
	}

	@Override
	public BatteryManufacture findById(long id) {
		// TODO Auto-generated method stub
		return batteryManufactureRepository.findById(id).get();
	}

	@Override
	public List<BatteryManufacture> findAll() {
		// TODO Auto-generated method stub
		return batteryManufactureRepository.findAll();
	}

	@Override
	public List<BatteryManufacture> findByBatteryid(long batteryid) {
		// TODO Auto-generated method stub
		return batteryManufactureRepository.findByBatteryid(batteryid);
	}

}
