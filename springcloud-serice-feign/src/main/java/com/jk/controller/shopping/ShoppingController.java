package com.jk.controller.shopping;

import com.jk.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 购物车模块
* */
@Controller
@RequestMapping("shopping")
public class ShoppingController {



    /*
    * 跳转购物车页面
    * */
    @RequestMapping("toShoppingCar")
    public String toShoppingCar(){
        return "shopping/shopping";
    }

}
