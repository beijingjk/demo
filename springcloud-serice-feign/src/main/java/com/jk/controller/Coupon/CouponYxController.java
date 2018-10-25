package com.jk.controller.Coupon;


import com.jk.model.Coupon;

import com.jk.model.Login;
import com.jk.service.Coupon.CouponServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("yx")

public class CouponYxController {


    @Autowired
    private CouponServiceApi couponService;


    //跳转优惠券页面
    @RequestMapping("toCoupon")
    public String toCoupon(){
        return "yx/Coupon";
    }

    //加载优惠券
    @RequestMapping("queryCouponYxList")
    @ResponseBody
    public List<Coupon> queryCouponYxList(){
        List<Coupon> clist =  couponService.queryCouponYxList();
            return clist;
    }

    //跳转已使用页面
    @RequestMapping("已使用.html")
    public String toGetUsed()
    {
        return "yx/toGetUsed";
    }


    //已使用页面跳转未使用页面
    @RequestMapping("优惠券-未使用.html")
    public String tiaocc(){
        return "yx/Coupon";
    }


    //查询已使用优惠券列表
    @RequestMapping("getUsedCouponList")
    @ResponseBody
    public List<Coupon> getUsedCouponList(){
        List<Coupon> clistss = couponService.getUsedCouponList();
        return clistss;
    }

   //已使用跳已过期
    @RequestMapping("已过期.html")
    public String ysgq(){
        return "yx/toExpired";
    }

    //查询过期优惠券列表
    @RequestMapping("toExpiredList")
    @ResponseBody
    public List<Coupon> toExpiredList(){
        List<Coupon> cclistss =  couponService.toExpiredList();
        return cclistss;
    }


    @RequestMapping("updateStatus")
    @ResponseBody
    public String updateStatus() {

        couponService.updateStatus();

        return "成功";

    }

    //领取优惠券
    @RequestMapping("updateCouponBi")
    @ResponseBody
    public String updateCouponBi(@RequestParam String id,HttpServletRequest request){
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute(session.getId());
        String userId = login.getUserId();
        /*String userId = "77";*/
        couponService.updateCouponBi(id,userId);

        return "修改成功";
    }






}
