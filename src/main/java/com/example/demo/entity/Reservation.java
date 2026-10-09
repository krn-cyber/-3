package com.example.demo.entity;

public class Reservation {
	
	// 予約ID
	private Long id;
	// 顧客ID
	private Long customerId;
	// 予約日
    private String reservationDate;
    // 予約時間
    private String reservationTime;
    // 物件名
    private String propertyName;
    // 備考欄
    private String memo;
    
    public Reservation() {
    }
    
    public Long getId() {
    	return id;
    }
    public void setId(Long id) {
    	this.id = id;
    }
    
    public Long getCustomerId() {
    	return customerId;
    }
    public void setCustomerId(Long customerId) {
    	this.customerId = customerId;
    }
    
    public String getReservationDate() {
    	return reservationDate;
    }
    public void setReservationDate(String reservationDate) {
    	this.reservationDate = reservationDate;
    }
    
    public String getPropertyName(){
    	return propertyName;
    }
    public void setPropertyName(String propertyName){
    	this.propertyName= propertyName;
    }
   
    public String getMemo(){
    	return memo;
    }
    public void setMemo(String memo){
    	this.memo = memo;
    }
}