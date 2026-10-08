package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.mapper.ReservationMapper;

@Service
public class ReservationService {

	private final ReservationMapper reservationMapper;

	public ReservationService(ReservationMapper reservationMapper) {
		this.reservationMapper = reservationMapper;
	}

	// 顧客を登録する
	public void register(Reservation reservation) {
		reservationMapper.insert(reservation);
	}
}