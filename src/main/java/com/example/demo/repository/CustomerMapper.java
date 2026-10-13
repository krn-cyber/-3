package com.example.demo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.demo.entity.Customer;

@Mapper
public interface CustomerMapper {

	Customer findByContact(
	 @Param("name") String name,
	 @Param("phoneNumber") String phoneNumber,
	 @Param("email") String email);
}