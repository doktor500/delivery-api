package uk.co.kenfos.api;

import com.google.common.collect.ImmutableMap;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static java.lang.System.currentTimeMillis;

@RestController
public class InfoController {

    @RequestMapping("/")
    public Map info() {
        return ImmutableMap.of("info", "delivery-api");
    }

    @Bean
    public HealthIndicator app() {
        return () -> Health.status("OK").withDetail("timestamp", currentTimeMillis()).build();
    }
}
