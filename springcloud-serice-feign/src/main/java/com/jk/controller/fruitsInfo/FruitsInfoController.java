package com.jk.controller.fruitsInfo;

import com.jk.model.Coupon;
import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.service.fruitsInfo.FruitsInfoServie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.jnlp.IntegrationService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("fruitsInfo")
public class FruitsInfoController {

    @Autowired
    private FruitsInfoServie fruitsInfoServie;


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



    /*
     *  薛长欢
     *
     *  跳转商品详情页并查询信息
     */
    @RequestMapping("toFruitsInfo")
    public String toFruitsInfo(Integer fruitsId, ModelMap modelMap, HttpServletRequest request){

        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            modelMap.put("flag","");
        }



        //根据商品id查询信息
        FruitsInfo fruitsInfo = fruitsInfoServie.queryFruitsInfoById(fruitsId);
        //根据登录人id查询优惠券
        List<Coupon> coupon = fruitsInfoServie.queryConponByUserId(attribute.getUserId());
        //相当于广告位/随机查询三条数据展示
        List<FruitsInfo> fruitsInfos = fruitsInfoServie.queryFruitsInfoRandom();
        modelMap.put("fruitsInfo",fruitsInfo);
        modelMap.put("coupon",coupon);
        modelMap.put("fruitsInfos",fruitsInfos);
        modelMap.put("flag",attribute.getUserName());
        return "fruitsInfo/fruitsInfo";
    }

    /*
     *  薛长欢
     *
     *  加入购物车
     */
    @RequestMapping("addCart")
    @ResponseBody
    public Map<String,Object> addCart(HttpServletRequest request,Integer fruitsId,Integer num){
        Map<String,Object> result = new HashMap<>();
        Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
        //flag为标识符  1 用户未登录 2 为商品信息存在数量加或减 3 商品不存在添加redis然后返回
        String flag = "1";
        if(login != null){
            result  = fruitsInfoServie.addCart(login.getUserId(),fruitsId,num);
            flag = (String) result.get("flag");
        }
        System.out.println(flag);
        result.put("flag",flag);
        return result;
    }

    /*
     *  孙丽景
     *
     *  从redis查询购物车
     */
    @RequestMapping("toShoppingCar")
    public String queryCartList(String code,HttpServletRequest request,ModelMap map){
        Login login = (Login) request.getSession().getAttribute(request.getSession().getId());

        //判断购物车是否为空
        String flag = "";
        if(login == null){
            flag = "";
            map.put("flag",flag);
            map.put("flag2","");
            return "shopping/shopping";
        }
            List<FruitsInfo> fruitsInfo = fruitsInfoServie.queryCartList(login.getUserId());
            if(fruitsInfo.size() == 0){
                flag = "";
                map.put("flag2",login.getUserName());
            }else{
                map.put("flag2",login.getUserName());
                flag = "fruitsInfo";
            }
            map.put("flag",flag);
            map.put("fruitsInfo",fruitsInfo);




        return "shopping/shopping";
    }

    /*
     *  薛长欢
     *
     *  删除购物车商品
     */
    @RequestMapping("deleteCart")
    @ResponseBody
    public Boolean deleteCart(Integer fruitsId,HttpServletRequest request){
        try{
            Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
            fruitsInfoServie.deleteCart(login.getUserId(),fruitsId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     *  薛长欢
     *
     *  清空购物车 根据登录id
     */
    @RequestMapping("deleteAllCart")
    public Boolean deleteAllCart(HttpServletRequest request){
        try{
            Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
            fruitsInfoServie.deleteAllCart(login.getUserId());
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     *  薛长欢
     *
     *  修改购物车
     */
    @RequestMapping("updateCart")
    @ResponseBody
    public Boolean updateCart(Integer fruitsId,Integer num,HttpServletRequest request){
        try{
            Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
            fruitsInfoServie.updateCart(login.getUserId(),fruitsId,num);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
