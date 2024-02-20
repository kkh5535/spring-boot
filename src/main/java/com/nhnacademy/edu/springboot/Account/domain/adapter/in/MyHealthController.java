package com.nhnacademy.edu.springboot.Account.domain.adapter.in;

import com.nhnacademy.edu.springboot.Account.management.MyHealthIndicator;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/management/fail")
@RequiredArgsConstructor
public class MyHealthController {
    private final MyHealthIndicator myHealthIndicator;
    @PostMapping
    public String setFail() {
        myHealthIndicator.setUnHealthy();

        return "ok";
    }
}
