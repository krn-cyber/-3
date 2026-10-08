package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Controller
public class CustomerController {

	private final CustomerService customerService;

	public CustomerController(CustomerService customerService){
		this.customerService = customerService;
	}

	// 顧客登録画面を表示する
	@GetMapping("/customer/new")
	public String newCustomer(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer-form";
	}
	// 顧客を登録する
	@PostMapping("/customer")
	public String register(Customer customer) {
		customerService.register(customer);
		return "redirect:/customer/complete";
	}
	@GetMapping("/customer/complete")
	public String complete() {
		return "customer-complete";
	}
	// 顧客検索を実行する
	@GetMapping("/customer/search")
	public String search(
			@org.springframework.web.bind.annotation.RequestParam
			String name,Model model) {
	
		List<Customer>customers = customerService.searchByName(name);
		
		model.addAttribute("customers",customers);
		model.addAttribute("name",name);
		
		return "customer-search";	
	}
}