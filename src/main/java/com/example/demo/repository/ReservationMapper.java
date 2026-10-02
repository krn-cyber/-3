package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Reservation;

@Mapper
public interface ReservationMapper {
	
	List<Reservation> findAll();
	
	void save(Reservation reservation);
	
	void deleteById(Long id);
	
	int getTotalPeople();
}
