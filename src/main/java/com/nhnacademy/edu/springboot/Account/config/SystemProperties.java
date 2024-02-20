package com.nhnacademy.edu.springboot.Account.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties("com.nhn.account.system")
public class SystemProperties {
    private String version;
}
