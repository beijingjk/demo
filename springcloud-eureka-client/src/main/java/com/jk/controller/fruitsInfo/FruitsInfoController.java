package com.jk.controller.fruitsInfo;

import com.jk.model.Coupon;
import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.service.fruitsInfo.FruitsInfoServieApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//@Controller
@RestController
@RequestMapping("fruitsInfo")
public class FruitsInfoController {

    @Autowired
    private FruitsInfoServieApi fruitsInfoServie;

    /*
     *  薛长欢
     *
     *  根据商品id查询信息
     */
    @RequestMapping("queryFruitsInfoById")
    public FruitsInfo queryFruitsInfoById(Integer fruitsId){
        return fruitsInfoServie.queryFruitsInfoById(fruitsId);
    }

    /*
     *  薛长欢
     *
     *  根据商品id查询信息
     */
    @RequestMapping("queryConponByUserId")
    public List<Coupon> queryConponByUserId(String loginId){
        return fruitsInfoServie.queryConponByUserId(loginId);
    }

    /*
     *  薛长欢
     *
     *  随机查询数据库三条数据
     */
    @RequestMapping("queryFruitsInfoRandom")
    public List<FruitsInfo> queryFruitsInfoRandom(){
        return fruitsInfoServie.queryFruitsInfoRandom();
    }

    /*
     *  薛长欢
     *
     *  加入购物车
     */
    @RequestMapping("addCart")
    public Map<String,Object> addCart(String loginId,Integer fruitsId,Integer num){
        return fruitsInfoServie.addCart(loginId,fruitsId,num);
    }

    /*
     *  薛长欢
     *
     *  查询购物车列表
     */
    @RequestMapping("queryCartList")
    public List<FruitsInfo> queryCartList(String loginId){
        return fruitsInfoServie.queryCartList(loginId);
    }

    /*
     *  薛长欢
     *
     *  删除购物车商品
     */
    @RequestMapping("deleteCart")
    public void deleteCart(String loginId,Integer fruitsId){
        fruitsInfoServie.deleteCart(loginId,fruitsId);
    }

    /*
     *  薛长欢
     *
     *  清空购物车 根据登录id
     */
    @RequestMapping("deleteAllCart")
    public void deleteAllCart(String loginId){
        fruitsInfoServie.deleteAllCart(loginId);
    }

    /*
     *  薛长欢
     *
     *  修改购物车
     */
    @RequestMapping("updateCart")
    public void updateCart(String loginId,Integer fruitsId,Integer num){
        fruitsInfoServie.updateCart(loginId,fruitsId,num);
    }
}
