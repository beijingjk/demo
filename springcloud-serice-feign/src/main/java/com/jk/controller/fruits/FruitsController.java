package com.jk.controller.fruits;

import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.service.fruits.FruitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("searchFruits")
public class FruitsController {

    @Autowired
    private FruitsService fruitsService;


    /*
     * 跳转首页
     */
    @RequestMapping("首页.html")
    public String toLayout2(HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
        return "index";
    }

    @RequestMapping("SearchFruits")
    @ResponseBody
    public List<FruitsInfo> SearchFruits(String title){

        return fruitsService.SearchFruits(title);
    }


    @RequestMapping("toSearchFruits")
    public String toSearchFruits(String input,HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
        request.setAttribute("input",input);
        return "searchfruits/searchfruits";
    }

}
