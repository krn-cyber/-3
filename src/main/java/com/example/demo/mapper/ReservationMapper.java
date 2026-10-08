package com.example.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Reservation;

@Mapper
public interface ReservationMapper {

// 予約を登録する	
	void insert(Reservation reservation);
}