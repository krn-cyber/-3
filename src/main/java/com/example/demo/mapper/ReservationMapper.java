package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Reservation;

@Mapper
public interface ReservationMapper {

// 予約を登録する	
	void insert(Reservation reservation);

// 予約一覧を取得する
	List<Reservation>findAll();

// IDで予約を検索する
	Reservation findById(@Param("id") Long id);

// 予約を削除する
	int deleteById(@Param("id") Long id);
}