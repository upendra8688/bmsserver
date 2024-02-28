package com.chaitu.springboot.batterymanagement.entities;

import java.time.LocalDateTime;


import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="battery_manufacture")
public class BatteryManufacture {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	private long batteryid;
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private LocalDateTime manufacture_datetime;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBatteryid() {
		return batteryid;
	}

	public void setBatteryid(long batteryid) {
		this.batteryid = batteryid;
	}

	public LocalDateTime getManufacture_datetime() {
		return manufacture_datetime;
	}

	public void setManufacture_datetime(LocalDateTime manufacture_datetime) {
		this.manufacture_datetime = manufacture_datetime;
	}
	
	

	
	
	
}
