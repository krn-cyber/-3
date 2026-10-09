package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Customer;

@Mapper
public interface CustomerMapper {
	
	// 顧客を登録する
	void insert (Customer customer);
	
   // 名前で顧客を検索する
	List<Customer> search(
			@Param("id")Long id,
			@Param("name")String name,
			@Param("phoneNumber")String phoneNumber,
			@Param("email")String email
			);
	
	// 顧客を削除する
	int deleteById(@Param("id") Long id);

}