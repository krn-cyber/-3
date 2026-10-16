package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerMapper;

@Service
public class CustomerService {
	
	private final CustomerMapper customerMapper;
	
	// コンストラクタ
	public CustomerService(CustomerMapper customerMapper) {
		this.customerMapper = customerMapper;
	}
	
	// 来場済みの顧客を検索する
	public List <Customer> searchVisitedCustomers(
			Long id,
			String name,
			String phoneNumber,
			String email){
		  return customerMapper.searchVisitedCustomers(id,name,phoneNumber,email); 

	}
}