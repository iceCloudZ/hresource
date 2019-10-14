package com.jiujiuhouse.resource.controller;

import com.jiujiuhouse.resource.entity.HouseDetailEntity;
import com.jiujiuhouse.resource.entity.HouseEntity;
import com.jiujiuhouse.resource.mvc.JsonResult;
import com.jiujiuhouse.resource.repository.HouseDetailRepository;
import com.jiujiuhouse.resource.repository.HouseRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ApiOperation(value = "检索房源")
    @GetMapping("/search")
    public JsonResult search() {
        HouseDetailEntity houseDetailEntity = new HouseDetailEntity();
        return JsonResult.create().addResult(houseDetailRepository.save(houseDetailEntity));
    }

    @ApiOperation(value = "首页列表")
    @GetMapping("/indexList")
    public JsonResult indexList(@RequestParam("index") Integer index) {
        Sort.Direction sort =  Sort.Direction.ASC;
        //获取PageRequest对象 index:页码 从0开始  size每页容量 sort排序方式 "id"->properties 以谁为准排序
        int size = 5;
        Pageable pageable = PageRequest.of(index, size, sort, "id");
        HouseEntity houseEntity = new HouseEntity();
        houseEntity.setId(index);
        //定义匹配规则 匹配"vendorId"这个属性 exact 精准匹配
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withMatcher("id",ExampleMatcher.GenericPropertyMatchers.exact());
        Example<HouseEntity> example = Example.of(houseEntity,exampleMatcher);
        Page<HouseEntity> page = houseRepository.findAll(example,pageable);
        //获取总页数
        page.getTotalPages();
        //获取总元素个数
        page.getTotalElements();
        //获取该分页的列表
        page.getContent();
        return JsonResult.create().addResult(houseRepository.findAll());
    }
}
