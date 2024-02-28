package com.chaitu.springboot.batterymanagement.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chaitu.springboot.batterymanagement.entities.BatteryData;
import com.chaitu.springboot.batterymanagement.repositories.BatteryDataRepository;

@Service
public class BatteryDataServiceImpl implements BatteryDataService {
	
	@Autowired
	private BatteryDataRepository batteryDataRepository;

	@Override
	public BatteryData save(BatteryData batteryData) {
		// TODO Auto-generated method stub
		return batteryDataRepository.save(batteryData);
	}

	@Override
	public List<BatteryData> findBybatteryid(long batteryid) {
		// TODO Auto-generated method stub
		return batteryDataRepository.findBybatteryid(batteryid);
	}

	@Override
	public BatteryData findById(long id) {
		// TODO Auto-generated method stub
		return batteryDataRepository.findById(id).get();
	}

	@Override
	public List<BatteryData> findAll() {
		// TODO Auto-generated method stub
		return batteryDataRepository.findAll();
	}

	@Override
	public List<Map<String,Object>> findByGiven(long batteryid,String variable) {
		// TODO Auto-generated method stub
		
		return batteryDataRepository.findByGiven( batteryid,variable);
	}

	@Override
	public List<Map<String, Object>> findByGivenTime(long batteryid, String variable, LocalDateTime startdatetime,LocalDateTime enddatetime) {
		// TODO Auto-generated method stub
		return batteryDataRepository.findByGivenTime(batteryid, variable, startdatetime, enddatetime);
	}

}
