package com.jk.controller.Coupon;

import com.jk.model.*;
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
    public void updateCouponBi(@RequestParam String id,@RequestParam String userId){
       /* HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute(session.getId());
        String userId = login.getUserId();*/
        /*String userId = "77";*/
        couponService.updateCouponBi(id,userId);

    }



    ///我的订单循环数据
    @RequestMapping(value = "getOrderList",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrderList(@RequestParam String userId){
        List<Order> olist =couponService.getOrderList(userId);
        return olist;
    }

    //获取顶部订单号和时间
    @RequestMapping(value = "getOrderLists",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrderLists(){
        List<Order> olists =couponService.getOrderLists();
        return olists;
    }

    //获取中间收货信息
    @RequestMapping(value = "getOrderList7",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderShipping> getOrderList7(){
        List<OrderShipping> olistsa =couponService.getOrderList7();
        return olistsa;
    }


    //获取最下方循环数据
    @RequestMapping(value = "getOrderList8",method = RequestMethod.GET)
    @ResponseBody
    public List<OrderItem> getOrderList8(){
        List<OrderItem> olistca =couponService.getOrderList8();
        return olistca;
    }

    //获取物流信息
    @RequestMapping(value = "getOrderList9",method = RequestMethod.GET)
    @ResponseBody
    public List<Order> getOrderList9(){
        List<Order> olistca =couponService.getOrderList9();
        return olistca;
    }

    //跳转退款页面
    @RequestMapping(value = "toBackPrice",method = RequestMethod.GET)
    @ResponseBody
    public Order toBackPrice(@RequestParam String orderId){
        Order order = couponService.toBackPrice(orderId);

        return order;
    }

    //退款（修改）
    @RequestMapping(value="editOrders",method = RequestMethod.POST)
    @ResponseBody
    public String editOrders(@RequestBody Order order){
        couponService.editOrders(order);
        return "退款成功";
    }



}
