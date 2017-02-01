package uk.co.kenfos.api;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HealthCheckController {

    @RequestMapping("/")
    public Map healthCheck() {
        return ImmutableMap.of("status", "ok");
    }
}
