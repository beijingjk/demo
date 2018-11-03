package com.jk.controller.shopping;

import com.jk.model.FruitsInfo;
import com.jk.service.shopping.ShoppingServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("shopp")
public class ShoppController {


    @Autowired
    private ShoppingServiceApi shoppingServiceApi;

    @RequestMapping("eidtOrderStatus")
    public void eidtOrderStatus(String id){
        shoppingServiceApi.eidtOrderStatus(id);
    }


    @RequestMapping("queryFruitsInfo")
    @ResponseBody
    public List<FruitsInfo> queryFruitsInfo(){
        return shoppingServiceApi.queryFruitsInfo();
    }

}
