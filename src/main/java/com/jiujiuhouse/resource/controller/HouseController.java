package com.jiujiuhouse.resource.controller;

import com.jiujiuhouse.resource.entity.HouseEntity;
import com.jiujiuhouse.resource.mvc.JsonResult;
import com.jiujiuhouse.resource.repository.HouseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

/**
 * @author zzh
 */
@RestController
@Api("房子相关接口")
@RequestMapping("/jiujiu/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @ApiOperation(value = "检索房源")
    @GetMapping("/search")
    public JsonResult search() {
        HouseEntity houseEntity = new HouseEntity();
        houseEntity.setCityId(15);
        houseEntity.setCommunityId(11);
        return JsonResult.create().addResult(houseRepository.save(houseEntity));
    }

    @ApiOperation(value = "首页列表")
    @GetMapping("/indexList")
    public JsonResult indexList() {
        HouseEntity houseEntity = new HouseEntity();
        houseEntity.setCityId(15);
        houseEntity.setCommunityId(11);
        return JsonResult.create().addResult(houseRepository.findAll());
    }
}
