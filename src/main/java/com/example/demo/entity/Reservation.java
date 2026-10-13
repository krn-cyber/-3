package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    
	//** 予約ID（DBで自動採番） */
	private Long id;
	//** 顧客ID */
	private Long customerId;
	
	
	//** 顧客情報*/
	private String name;
	private String phoneNumber;
	private String email;
	
	
	//** 予約情報 */
	private String reservationDate;
	private String reservationTime;
	
	private Integer numberOfPeople;
	private String propertyName;
	private String memo;

}
