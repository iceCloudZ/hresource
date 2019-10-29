package com.jiujiuhouse.huser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class HeartBeatController {

    @GetMapping("/health")
    public String HeartBeat() {
        log.info("HeartBeating");
        return "health";
    }
}
