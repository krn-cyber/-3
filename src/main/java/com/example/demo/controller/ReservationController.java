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
	    
        // 予約一覧：最初は今日の日付を表示
	    @GetMapping("/reservations")
	    public String reservationList(
	    		@RequestParam(required = false) String date,
	    		Model model) {
	    	
	    // 日付が指定されていなければ、今日の日付にする
	        if (date == null || date.isBlank()) {
	            date = java.time.LocalDate.now(
	                   java.time.ZoneId.of("Asia/Tokyo")).toString();
	        }
	        
	    // 指定した日付の予約を取得
	    	model.addAttribute("reservations", reservationService.findByDate(date));
	    	
	    // 画面に表示する日付
	    	model.addAttribute("selectedDate",date);
	    	
	    // 前日、翌日
	    	java.time.LocalDate selected =
	    			java.time.LocalDate.parse(date);
	    	
	    	model.addAttribute("previousDate",selected.minusDays(1).toString());

	    	model.addAttribute("nextDate",selected.plusDays(1).toString());

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
	    
	    // 来場済みに変更
	    @PostMapping("/reservations/visited")
	    public String markVisited(@RequestParam Long id) {
	    	reservationService.markVisited(id);
	    	return "redirect:/reservations";
	    	
          }
	}