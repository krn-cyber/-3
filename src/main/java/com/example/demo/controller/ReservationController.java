package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Reservation;
import com.example.demo.service.ReservationService;

@Controller
public class ReservationController {

	 private final ReservationService reservationService;

	    public ReservationController(ReservationService reservationService) {
	        this.reservationService = reservationService;
	    }
	    
	    @GetMapping("/")
	    public String index() {
	    	return "redirect:/login";
	    }

	    @GetMapping("/login")
	    public String login() {
	        return "login";
	    }
	    @GetMapping("/menu")
	    public String menu() {
	    	return "menu";
	    }
	    
        // 予約一覧
	    @GetMapping("/reservations")
	    public String reservationList(Model model) {

	        model.addAttribute( "reservations",reservationService.findAll()
	        );
	        return "reservations-list";
	    }
	    
        // 予約フォーム
	    @GetMapping("/reservation/new")
	    public String reservationForm(Model model) {
            model.addAttribute("reservation",new Reservation() );
	        return "reservation-form";
	    }

	    // 予約登録
	    @PostMapping("/reservations")
	    public String createReservation(
	        @ModelAttribute Reservation reservation,Model model) {
	        
	    	try {
	    	reservationService.save(reservation);
	        return "redirect:/reservations";
	    } catch (IllegalArgumentException e) {
	    	model.addAttribute("errorMessage", e.getMessage());
	    	model.addAttribute("reservation",reservation);
	        return "reservation-form";
	      }
	    }
	    
	    // 予約キャンセル
	    @PostMapping("/reservations/delete")
	    public String deleteReservation(@RequestParam Long id) {
	        reservationService.delete(id);
	        return "redirect:/reservations";
	    }
	}