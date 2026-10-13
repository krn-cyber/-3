package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Reservation;

@Mapper
public interface ReservationMapper {
	
	List<Reservation> findAll();
	
	int save(Reservation reservation);
	
	int deleteById(Long id);
	
	int getTotalPeople();
}