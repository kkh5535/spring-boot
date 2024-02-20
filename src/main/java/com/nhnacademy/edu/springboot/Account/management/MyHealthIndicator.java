package com.nhnacademy.edu.springboot.Account.management;

import lombok.Getter;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class MyHealthIndicator implements HealthIndicator {
    private final AtomicBoolean healthy = new AtomicBoolean(true);

    public void setUnHealthy() {
        this.healthy.set(false);
    }
    @Override
    public Health health() {
        if (healthy.get()) {
            return Health.up().withDetail("reason", "i don,t know").build();
        }
        return Health.down().withDetail("reason", "fail").build();
    }
}
