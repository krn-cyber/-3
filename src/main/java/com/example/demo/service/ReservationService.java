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
	public List<Reservation> findAll(){
		return reservationMapper.findAll();
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
	
	// ②顧客が見つからなければ登録を中止
	if(customer == null) {
		throw new IllegalArgumentException(
		"顧客情報が見つかりません。名前・電話番号・メールアドレスを確認してください。");
	}
	
	// ③取得した顧客IDを予約に設定
	reservation.setCustomerId(customer.getId());
	
	// ④予約を登録
	reservationMapper.save(reservation);
}
	public void delete(Long id) {
		reservationMapper.deleteById(id);
	}
	
	public int getTotalPeople() {
		return reservationMapper.getTotalPeople();
	  }
	}