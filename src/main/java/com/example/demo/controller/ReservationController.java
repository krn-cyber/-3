package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@Controller
public class ReservationController {

	private final ReservationService reservationService;

	public ReservationController(ReservationService reservationService){
		this.reservationService = reservationService;
	}

	// 予約一覧画面を表示する
	@GetMapping("/reservation/list")
	public String newReservation(Model model) {
		model.addAttribute("reservations", reservationService.findAll()
				);
		return "reservation-list";
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
	// 予約一覧
	@PostMapping("/reservation/list")
	public String list(Model model) {
		List<Reservation> reservations = reservationService.findAll();
	    model.addAttribute("reservations",reservations);
	     return "reservation-list";
	}
	// IDで予約検索
	@GetMapping("/reservation/search")
	public String search(@RequestParam Long id, Model model) {
		Reservation reservation = reservationService.findById(id);
		model.addAttribute("reservation" ,reservation);
	     return "reservation-search";
	}
	
    // 予約削除
	@PostMapping("/reservation/delete")
	public String delete(@RequestParam Long id) {
		reservationService.deleteById(id);
		return "redirect:/reservation/list";
   }
}