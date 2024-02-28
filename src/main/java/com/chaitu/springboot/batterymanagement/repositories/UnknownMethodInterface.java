package com.chaitu.springboot.batterymanagement.repositories;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;

import org.springframework.data.repository.query.Param;

public interface UnknownMethodInterface {

	public List<Map<String, Object>> findByGivenTime(long batteryid, String variable, LocalDateTime startdatetime,
			LocalDateTime enddatetime);
	
	 public List<Map<String,Object>> findByGiven(@Param("batteryid")long batteryid,@Param("column")String variable);


}