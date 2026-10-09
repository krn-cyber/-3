package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.mapper.ReservationMapper;

@Service
public class ReservationService {

	private final ReservationMapper reservationMapper;

	public ReservationService(ReservationMapper reservationMapper) {
		this.reservationMapper = reservationMapper;
	}

	// 予約を登録する
	public void register(Reservation reservation) {
		reservationMapper.insert(reservation);
	}
	// 予約を一覧を取得する
	public List<Reservation> findAll(){ 
		return reservationMapper.findAll();
	}
	// IDで予約を検索する
	public Reservation findById(Long id) {
	    return reservationMapper.findById(id);
     }
	// 予約を削除する
	public int deleteById(Long id) {
		return reservationMapper.deleteById(id);
	}
}