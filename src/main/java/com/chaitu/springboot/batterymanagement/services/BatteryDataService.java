package com.chaitu.springboot.batterymanagement.services;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

import com.chaitu.springboot.batterymanagement.entities.BatteryData;

public interface BatteryDataService {
	
	public BatteryData save(BatteryData batteryData);
	
	public List<BatteryData> findBybatteryid(long batteryid);
	
	public BatteryData findById(long id);
	public List<BatteryData> findAll();
	
	public List<Map<String,Object>> findByGiven(long batteryid,String variable);
	
	public List<Map<String,Object>> findByGivenTime(@Param("batteryid") long batteryid,@Param("column") String variable,@Param("startdatetime") LocalDateTime startdatetime,@Param("enddatetime") LocalDateTime enddatetime);


}
