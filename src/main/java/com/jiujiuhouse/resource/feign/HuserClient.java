package com.jiujiuhouse.resource.feign;

import com.alibaba.fastjson.JSONObject;
import com.jiujiuhouse.resource.feign.hystrix.HuserClientHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author zihao.zhao
 */
@FeignClient(name = "huser", fallback = HuserClientHystrix.class)
public interface HuserClient {

    @GetMapping("/huser/tested")
    String getTested();
}
