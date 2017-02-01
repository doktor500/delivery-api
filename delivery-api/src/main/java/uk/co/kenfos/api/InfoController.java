package uk.co.kenfos.api;

import com.google.common.collect.ImmutableMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class InfoController {

    @RequestMapping("/")
    public Map info() {
        return ImmutableMap.of("info", "delivery-api");
    }
}
