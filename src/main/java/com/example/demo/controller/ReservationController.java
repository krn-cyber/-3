package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@Controller
public class ReservationController {

	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService){
		this.reservationService = reservationService;
	}

	// 予約登録画面を表示する
	@GetMapping("/reservation/new")
	public String newReservation(Model model) {
		model.addAttribute("reservation", new Reservation());
		return "reservation-form";
	}
	// 予約を登録する
	@PostMapping("/reservation")
	public String register(Reservation reservation) {
		reservationService.register(reservation);
		return "redirect:/reservation/complete";
	}
	// 予約登録完了画面
	@GetMapping("/reservation/complete")
	public String complete() {
		return "reservation-complete";
	}
}
