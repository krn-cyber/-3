package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Customer;

@Mapper
public interface CustomerMapper {

	// 名前・電話番号・メールアドレスから顧客を検索
	Customer findByContact(
	 @Param("name") String name,
	 @Param("phoneNumber") String phoneNumber,
	 @Param("email") String email
	 );
	
	// 顧客を新規登録する
	void insert(Customer customer);
	
	// 来場済みの顧客を条件指定して検索する
	List<Customer> searchVisitedCustomers(
		@Param("id") Long id,
		@Param("name") String name,
		@Param("phoneNumber") String phoneNumber,
		@Param("email") String email
			);
	
}