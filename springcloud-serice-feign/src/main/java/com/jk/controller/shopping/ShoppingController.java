package com.jk.controller.shopping;

import com.jk.model.FruitsInfo;
import com.jk.service.shopping.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/*
 *  孙丽景
 *
 *  购物车模块
 */
@Controller
@RequestMapping("shopping")
public class ShoppingController {


    @Autowired
    private ShoppingService shoppingService;


    /*
     *  孙丽景
     *
     *  查询大家都在看
     */
    @RequestMapping("queryFruitsInfo")
    @ResponseBody
    public List<FruitsInfo> queryFruitsInfo(){
        List<FruitsInfo> fruitsInfos = shoppingService.queryFruitsInfo();
        return fruitsInfos;
    }








}
