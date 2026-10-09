package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Customer;
import com.example.demo.mapper.CustomerMapper;

@Service
public class CustomerService {
	
	private final CustomerMapper customerMapper;
	
	public CustomerService(CustomerMapper customerMapper) {
		 this.customerMapper = customerMapper;
	}
	
	// 顧客を登録する
	public void register(Customer customer) {
		customerMapper.insert(customer);
	}
	// 顧客を登録する
	public List<Customer> search(
			Long id,
			String name,
			String phoneNumber,
			String email) {
		return customerMapper.search(id,name,phoneNumber,email);
	}
    // 顧客を削除
	public void deleteById(Long id) {
		customerMapper.deleteById(id);
	}
}