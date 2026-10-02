package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    
	//** ログインID */
	private Long id;
	//** 名前 */
	private String name;
	//** 電話番号 */
	private String phonenumber;
	//** メールアドレス */
	private String email;
	//** 予約日 */
	private String reservationdate;
	//** 予約時間 */
	private String reservationtime;
	//** 予約人数 */
	private Integer numberOfPeople;
	//** 備考欄 */
	private String memo;

}
