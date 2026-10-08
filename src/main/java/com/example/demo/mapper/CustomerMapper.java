package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.entity.Customer;

@Mapper
public interface CustomerMapper {
	
	// 顧客を登録する
	void insert (Customer customer);
	
   // 名前で顧客を検索する
	List<Customer> searchByname(String name);
}