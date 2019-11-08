package com.jiujiuhouse.resource.controller;

import com.jiujiuhouse.resource.repository.HouseDetailRepository;
import com.jiujiuhouse.resource.repository.HouseRepository;
import com.jiujiuhouse.resource.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @author zzh
 */
//@RestController
//@RequestMapping("/jiujiu/house")
public class HouseController {

    @Autowired
    private HouseRepository houseRepository;

    @Autowired
    private HouseDetailRepository houseDetailRepository;

    @Autowired
    private HouseService houseService;

//    @ApiOperation(value = "检索房源")
//    @GetMapping("/search")
//    public JsonResult search() {
//        HouseDetailEntity houseDetailEntity = new HouseDetailEntity();
//        return JsonResult.create().addResult(houseDetailRepository.save(houseDetailEntity));
//    }
//
//    @ApiOperation(value = "首页列表")
//    @GetMapping("/indexList")
//    public JsonResult indexList(@RequestParam("index") Integer index) {
//        return JsonResult.create().addResult(houseService.getList(8, index));
//    }
}
