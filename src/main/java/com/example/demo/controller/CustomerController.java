
package com.example.demo.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // 顧客検索画面を表示する
    @GetMapping("/search")
    public String showSearchForm() {
        return "customer-search";
    }

    // 顧客を検索する
    @GetMapping("/results")
    public String searchCustomers(
            @RequestParam(required = false) Long id,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String phoneNumber,
            @RequestParam(required = false) String email,
            Model model) {

        // 入力値の前後の空白を取り除く
        name = clean(name);
        phoneNumber = clean(phoneNumber);
        email = clean(email);

        // すべて空欄なら検索しない
        if (id == null && name == null
                && phoneNumber == null && email == null) {
            model.addAttribute(
                    "message",
                    "検索条件を1つ以上入力してください。");
            return "customer-search";
        }

        // 来場済みの顧客を検索する
        List<Customer> customers =
                customerService.searchVisitedCustomers(
                        id, name, phoneNumber, email);

        // 検索条件と検索結果を画面に渡す
        model.addAttribute("customers", customers);
        model.addAttribute("searchId", id);
        model.addAttribute("searchName", name);
        model.addAttribute("searchPhoneNumber", phoneNumber);
        model.addAttribute("searchEmail", email);

        // 検索結果が0件の場合
        if (customers.isEmpty()) {
            model.addAttribute(
                    "message",
                    "該当する来場済み顧客が見つかりませんでした。");
        }

        return "customer-search";
    }

    // 前後の空白を取り除く
    private String clean(String value) {
        if (value == null || value.trim().isEmpty()) {
            return null;
        }
        return value.trim();
    }
}
