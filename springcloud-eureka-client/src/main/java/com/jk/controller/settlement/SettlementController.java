package com.jk.controller.settlement;

import com.jk.model.Area;
import com.jk.model.OrderInfo;
import com.jk.service.settlement.SetelementServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("element")
public class SettlementController {

    @Autowired
    private SetelementServiceApi elementService;

    /*
     *  薛长欢
     *
     *  查询省
     */
    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea(){
        List<Area> areas = elementService.queryArea();
        return areas;
    }

    /*
     *  薛长欢
     *
     *  查询市/区
     */
    @RequestMapping("queryAreaByPid")
    @ResponseBody
    public List<Area> queryAreaByPid(Integer pid){
        return elementService.queryAreaByPid(pid);
    }

    /*
     *  薛长欢
     *
     *  添加地址
     */
    @RequestMapping("addAddress")
    public void addAddress(@RequestBody Area area){
        elementService.addAddress(area);
    }

    @RequestMapping("queryAreaByUserId")
    public List<Area> queryAreaByUserId(String loginId){
        return elementService.queryAreaByUserId(loginId);
    }

    @RequestMapping("createOrder")
    public Map<String,Object> createOrder(@RequestBody OrderInfo orderInfo){
        return elementService.createOrder(orderInfo);
    }
}
