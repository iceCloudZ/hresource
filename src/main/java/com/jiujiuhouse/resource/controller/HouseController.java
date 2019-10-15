package com.jiujiuhouse.resource.controller;

import com.jiujiuhouse.resource.entity.HouseDetailEntity;
import com.jiujiuhouse.resource.mvc.JsonResult;
import com.jiujiuhouse.resource.repository.HouseDetailRepository;
import com.jiujiuhouse.resource.repository.HouseRepository;
import com.jiujiuhouse.resource.service.HouseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author zzh
 */
@RestController
@Api("房子相关接口")
@RequestMapping("/jiujiu/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseDetailRepository houseDetailRepository;

    @Autowired
    private HouseService houseService;

    @ApiOperation(value = "检索房源")
    @GetMapping("/search")
    public JsonResult search() {
        HouseDetailEntity houseDetailEntity = new HouseDetailEntity();
        return JsonResult.create().addResult(houseDetailRepository.save(houseDetailEntity));
    }

    @ApiOperation(value = "首页列表")
    @GetMapping("/indexList")
    public JsonResult indexList(@RequestParam("index") Integer index) {
        return JsonResult.create().addResult(houseService.getList(8, index));
    }
}
