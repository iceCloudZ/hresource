package com.jiujiuhouse.resource.feign;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HuserService {
    private final RestTemplate restTemplate;

    public HuserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @HystrixCommand(fallbackMethod = "getFallbackName", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
    })
    public JSONObject getProfiles() {
        return this.restTemplate.getForObject("http://huser/huser/profiles", JSONObject.class);
    }

    private JSONObject getFallbackProfiles() {
        return JSONObject.parseObject("{err:'熔断了'}");
    }
}
