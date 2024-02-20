package com.nhnacademy.edu.springboot.Account.domain.adapter.in;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthorInfoContributor implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("Author", Map.of("name", "kkh"));
    }
}
