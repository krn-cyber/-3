package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Reservation;
import com.example.demo.repository.ReservationMapper;

@Service
public class ReservationService {

	private final ReservationMapper reservationMapper;
	
	public ReservationService(ReservationMapper reservationMapper) {
		this.reservationMapper = reservationMapper;
	}
	
	public List<Reservation> findAll(){
		return reservationMapper.findAll();
	}
	
	public void save(Reservation reservation) {
		reservationMapper.save(reservation);
	}
	public void delete(Long id) {
		reservationMapper.deleteById(id);
	}
	public int getTotalPeople() {
		return reservationMapper.getTotalPeople();
	}
}
