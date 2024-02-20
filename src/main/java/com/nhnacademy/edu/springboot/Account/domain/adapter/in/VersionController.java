package com.nhnacademy.edu.springboot.Account.domain.adapter.in;

import com.nhnacademy.edu.springboot.Account.config.SystemProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/system/version")
@RequiredArgsConstructor
public class VersionController {
    private final SystemProperties systemProperties;

    @GetMapping
    public Map<String, String> getVersion() {
        return Map.of("version", systemProperties.getVersion());
    }
}
