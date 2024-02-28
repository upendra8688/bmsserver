package com.chaitu.springboot.batterymanagement.repositories;

import java.sql.Timestamp;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Service
public class UnknownMethod implements UnknownMethodInterface {
	
	@PersistenceContext//EntityManager operates within a persistence context, which is a short-lived memory cache for entities. It helps track changes, handle relationships between entities, and propagate changes to the database.
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByGivenTime(long batteryid, String variable, LocalDateTime startdatetime, LocalDateTime enddatetime) {
        String sql = "SELECT batteryid, " + columnToSelect(variable) + " AS column_value " +
                     "FROM battery_data " +
                     "WHERE batteryid = :batteryid " +
                     "AND datetime BETWEEN :startdatetime AND :enddatetime";

        Query query = entityManager.createNativeQuery(sql);
        query.setParameter("batteryid", batteryid);
        query.setParameter("startdatetime", startdatetime);
        query.setParameter("enddatetime", enddatetime);

        List<Object[]> resultList = query.getResultList();
        List<Map<String, Object>> result = new ArrayList<>();

        for (Object[] row : resultList) {
            Map<String, Object> row1Map = new LinkedHashMap<>();
            row1Map.put("batteryid", row[0]);
            if(row[1] instanceof Timestamp) {
                Timestamp timestamp = (Timestamp) row[1];
                Instant instant = timestamp.toInstant();
                LocalDateTime localDateTime = instant.atZone(ZoneOffset.UTC).toLocalDateTime();
                LocalTime localTime = localDateTime.toLocalTime();
                
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
                String formattedDateTime = localDateTime.format(formatter);
                localDateTime = LocalDateTime.parse(formattedDateTime, formatter);
                row1Map.put(variable, formattedDateTime);}
            else {
            row1Map.put(variable, row[1]);}
            result.add(row1Map);
            
        }

        return result;
    }

    private String columnToSelect(String column) {
        switch (column) {
            case "voltage":
                return "voltage";
            case "current":
                return "current";
            case "temperature":
                return "temperature";
            case "datetime":
                return "datetime";
            default:
                return "null";
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Map<String, Object>> findByGiven(long batteryid, String variable) {
		String sql = "SELECT batteryid, " + columnToSelect(variable) + " AS column_value " +
                "FROM battery_data " +
                "WHERE batteryid = :batteryid";

   Query query = entityManager.createNativeQuery(sql);
   query.setParameter("batteryid", batteryid);


List<Object[]> resultList = query.getResultList();
   List<Map<String, Object>> result = new ArrayList<>();
   for (Object[] row : resultList) {
	   System.out.println(row[1].getClass());
       Map<String, Object> row1Map = new LinkedHashMap<>();
       row1Map.put("batteryid", row[0]);
       if(row[1] instanceof Timestamp) {
           Timestamp timestamp = (Timestamp) row[1];
           Instant instant = timestamp.toInstant();
           LocalDateTime localDateTime = instant.atZone(ZoneOffset.UTC).toLocalDateTime();
           LocalTime localTime = localDateTime.toLocalTime();
           System.out.println(localDateTime.toString());
           
           DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
           String formattedDateTime = localDateTime.format(formatter);
           localDateTime = LocalDateTime.parse(formattedDateTime, formatter);
           row1Map.put(variable, formattedDateTime);}
       else
           row1Map.put(variable, row[1]);
           result.add(row1Map);
   }

   return result;

}
}
