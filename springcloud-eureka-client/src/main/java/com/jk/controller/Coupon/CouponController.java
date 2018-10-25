package com.jk.controller.Coupon;

import com.jk.model.Coupon;
import com.jk.model.Login;
import com.jk.service.Coupon.CouponServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("yx")

public class CouponController {

    @Autowired
    private CouponServiceApi couponService;


    //加载优惠券
    @RequestMapping(value = "queryCouponYxList",method = RequestMethod.GET)
    @ResponseBody
    public List<Coupon> queryCouponYxList(HttpServletRequest request){
        List<Coupon> clist = couponService.queryCouponYxList();
        return clist;
    }

    //跳转已使用页面
    @RequestMapping("已使用.html")
    public String toGetUsed()
    {
        return "yx/toGetUsed";
    }

    //查询已使用优惠券列表
    @RequestMapping(value = "getUsedCouponList",method = RequestMethod.GET)
    @ResponseBody
    public List<Coupon> getUsedCouponList(){
        List<Coupon> clistss = couponService.getUsedCouponList();
        return clistss;
    }

    //查询过期优惠券列表
    @RequestMapping(value = "toExpiredList",method = RequestMethod.GET)
    @ResponseBody
    public List<Coupon> toExpiredList(){
        List<Coupon> cclistss =  couponService.toExpiredList();
        return cclistss;
    }


    @RequestMapping(value = "updateStatus",method = RequestMethod.GET)
    @ResponseBody
    public String updateStatus() {

        couponService.updateStatus();

        return "成功";

    }

    //领取优惠券
    @RequestMapping(value = "updateCouponBi",method = RequestMethod.POST)
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
