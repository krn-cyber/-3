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
	    public String login(Model model) {
	    	model.addAttribute("loginForm",new LoginForm());
	        return "login";
	    }

	    @GetMapping("/reservations")
	    public String reservationList(Model model) {

	        model.addAttribute(
	                "reservations",
	                reservationService.findAll()
	        );

	        return "reservation-list";
	    }

	    @GetMapping("/reservations/new")
	    public String reservationForm(Model model) {

	        model.addAttribute(
	                "reservation",
	                new Reservation()
	        );

	        return "reservation-form";
	    }

	    @PostMapping("/reservations")
	    public String createReservation(
	            @ModelAttribute Reservation reservation) {

	        reservationService.save(reservation);

	        return "redirect:/reservations";
	    }

	    @PostMapping("/reservations/delete")
	    public String deleteReservation(
	            @RequestParam Long id) {

	        reservationService.delete(id);

	        return "redirect:/reservations";
	    }
	}
