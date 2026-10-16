package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Reservation;
import com.example.demo.repository.CustomerMapper;
import com.example.demo.repository.ReservationMapper;

@Service
public class ReservationService {

	private final ReservationMapper reservationMapper;
	private final CustomerMapper customerMapper;
	
	// コンストラクタ
	public ReservationService(ReservationMapper reservationMapper,
		CustomerMapper customerMapper) {
		
		this.reservationMapper = reservationMapper;
		this.customerMapper = customerMapper;
	}
	
	// 予約一覧
	public List <Reservation> findAll(){
		  return reservationMapper.findAll();
	}
	
	// 指定した日付の予約を取得
	public List <Reservation> findByDate(String reservationDate){
		  return reservationMapper.findByDate(reservationDate);
	}
	
	// 予約登録
	@Transactional
	public void save(Reservation reservation) {
	
	// ①フォームの顧客情報から既存顧客を検索 
	Customer customer = customerMapper.findByContact(
		reservation.getName(),
	    reservation.getPhoneNumber(),
	    reservation.getEmail()
	    );
	
	// ②顧客が見つからなければ新規登録
	if(customer == null) {
		customer = new Customer();
		customer.setName(reservation.getName());
		customer.setPhoneNumber(reservation.getPhoneNumber());
		customer.setEmail(reservation.getEmail());
		
		customerMapper.insert(customer);
	}
	
	// ③顧客IDを予約に設定
	reservation.setCustomerId(customer.getId());
	
	// ④予約を登録
	reservationMapper.save(reservation);
    }
	public void delete(Long id) {
		reservationMapper.deleteById(id);
	}
	
	// ⑤来場状況を更新
	public void markVisited(Long id) {
		reservationMapper.markVisited(id);
	}
	
	public int getTotalPeople() {
		return reservationMapper.getTotalPeople();
	  }
	}