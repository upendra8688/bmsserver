package com.chaitu.springboot.batterymanagement.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chaitu.springboot.batterymanagement.entities.BatteryManufacture;

public interface BatteryManufactureRepository extends JpaRepository<BatteryManufacture, Long> {
	
	public List<BatteryManufacture> findByBatteryid(long batteryid);

}
