package com.jiujiuhouse.resource;

import com.alibaba.fastjson.JSON;
import com.jiujiuhouse.resource.feign.HuserClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zihao.zhao
 */
@RestController
@Slf4j
public class HeartBeatController {


    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private HuserClient huserClient;

    private final String hostName = System.getenv("HOSTNAME");

    @PostConstruct
    public void init() {
        log.info("健康检查服务初始化.{}", hostName);
    }

    @GetMapping("/health")
    public String HeartBeat() {
        return "health";
    }

    /**
     * 返回远程调用的结果
     *
     * @return
     */
    @RequestMapping("/getservicedetail")
    public String getservicedetail(
            @RequestParam(value = "servicename", defaultValue = "") String servicename) {
        return "Service [" + servicename + "]'s instance list : " + JSON.toJSONString(discoveryClient.getInstances(servicename));
    }

    /**
     * 返回发现的所有服务
     *
     * @return
     */
    @RequestMapping("/services")
    public String services() {
        return this.discoveryClient.getServices().toString()
                + ", "
                + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    /**
     * 测试openfeign调用
     *
     * @return
     */
    @RequestMapping("/test")
    public String test() {
        log.info("hostname:{}", this.hostName);
        return huserClient.getTested();
    }


    /**
     * 测试openfeign调用
     *
     * @return
     */
    @RequestMapping("/tested")
    public String tested() {
        log.info("hostname:{}", this.hostName);
        return "hresource被调用了" + "hostname:" + this.hostName;
    }
}
