package com.nhnacademy.edu.springboot.Account.domain.adapter.in;

import com.nhnacademy.edu.springboot.Account.domain.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class AccountWebController {
    @GetMapping("/web/accounts/{id}")
    public String getAccount(@PathVariable("id") Long id, Model model) {
        model.addAttribute("account", new Account(1L, "kkh", 100));

        return "account";
    }
}
