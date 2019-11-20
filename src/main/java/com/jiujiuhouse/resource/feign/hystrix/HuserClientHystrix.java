package com.jiujiuhouse.resource.feign.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.jiujiuhouse.resource.feign.HuserClient;

/**
 * @author zihao.zhao
 */
public class HuserClientHystrix implements HuserClient {
    @Override
    public String getTested() {
        return "hresource熔断了.";
    }
}
