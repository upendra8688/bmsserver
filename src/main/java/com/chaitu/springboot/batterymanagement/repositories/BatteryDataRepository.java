package com.chaitu.springboot.batterymanagement.repositories;

import java.time.LocalDateTime;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.chaitu.springboot.batterymanagement.entities.BatteryData;

public interface BatteryDataRepository extends JpaRepository<BatteryData,Long> {
	
	
	public List<BatteryData> findBybatteryid(long batteryid);
	
	@Query(value = "SELECT b.batteryid as batteryid," +
            "CASE " +
            "   WHEN :column = 'voltage' THEN CAST(b.voltage AS DECIMAL(10, 2))" +
            "   WHEN :column = 'current' THEN b.current " +
            "   WHEN :column = 'temperature' THEN b.temperature " +
            "	WHEN :column = 'datetime' THEN b.datetime "+
            "   ELSE null " +
            "END AS :column " +
            "FROM battery_data as b " +
            "WHERE b.batteryid = :batteryid", nativeQuery = true)
	 public List<Map<String,Object>> findByGiven(@Param("batteryid")long batteryid,@Param("column")String variable);
	
	
	@Query(value = "SELECT b.batteryid as batteryid,b.temperature as voltage, " +
            "CASE " +
            "   WHEN :column = 'voltage' THEN CAST(b.voltage AS DOUBLE) " +
            "   WHEN :column = 'current' THEN b.current " +
            "   WHEN :column = 'temperature' THEN b.temperature " +
            "	WHEN :column = 'datetime' THEN b.datetime "+
            "   ELSE null " +
            "END AS :column " +
            "FROM battery_data as b " +
            "WHERE b.batteryid = :batteryid "+
            "AND b.datetime BETWEEN :startdatetime AND :enddatetime", nativeQuery = true)
	 public List<Map<String,Object>> findByGivenTime(@Param("batteryid") long batteryid,@Param("column") String variable,@Param("startdatetime") LocalDateTime startdatetime,@Param("enddatetime") LocalDateTime enddatetime);

}
