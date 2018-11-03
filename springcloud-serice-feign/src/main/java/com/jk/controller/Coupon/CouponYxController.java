package com.jk.controller.Coupon;


import com.jk.model.Coupon;

import com.jk.model.*;
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
    public String toGetUsed(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
        return "yx/toGetUsed";
    }


    //已使用页面跳转未使用页面
    @RequestMapping("优惠券-未使用.html")
    public String tiaocc(HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
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
    public Boolean updateCouponBi(@RequestParam String id,HttpServletRequest request){
        /*String userId = "77";*/

        try{
            HttpSession session = request.getSession();
            Login login = (Login) session.getAttribute(session.getId());
            String userId = login.getUserId();
            couponService.updateCouponBi(id,userId);

        }catch (Exception e){
            return false;
        }
        return true;
    }



    //跳转我的订单页面
    @RequestMapping("toMyOrder")
    public String toMyOrder(HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
        return "yx/toMyOrder";
    }

    //跳转我的订单页面
    @RequestMapping("我的订单.html")
    public String toMyOrders(HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
        return "yx/toMyOrder";
    }

    //跳转我的订单详情页面
    @RequestMapping("订单详情.html")
    public String toOrderDetails(HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }else{
            request.setAttribute("flag",attribute.getUserName());
        }
        return "yx/toOrderDetails";
    }

    //我的订单循环数据
    @RequestMapping("getOrderList")
    @ResponseBody
    public List<Order> getOrderList(HttpServletRequest request){
        HttpSession session = request.getSession();
        Login login = (Login) session.getAttribute(session.getId());
        String userId = login.getUserId();
        List<Order> olist =couponService.getOrderList(userId);
        return olist;
    }

    //获取顶部订单号和时间
    @RequestMapping("getOrderLists")
    @ResponseBody
    public List<Order> getOrderLists(){
        List<Order> olists =couponService.getOrderLists();
        return olists;
    }

    //获取中间收货信息
    @RequestMapping("getOrderList7")
    @ResponseBody
    public List<OrderShipping> getOrderList7(){
        List<OrderShipping> olistsa =couponService.getOrderList7();
        return olistsa;
    }

    //获取最下方循环数据
    @RequestMapping("getOrderList8")
    @ResponseBody
    public List<OrderItem> getOrderList8(){
        List<OrderItem> olistca =couponService.getOrderList8();
        return olistca;
    }

    //获取物流信息
    @RequestMapping("getOrderList9")
    @ResponseBody
    public List<Order> getOrderList9(){
        List<Order> olistca =couponService.getOrderList9();
        return olistca;
    }

    //跳转退款页面
    @RequestMapping("toBackPrice")
    public String toBackPrice(String orderId,HttpServletRequest request){
        HttpSession session = request.getSession();
        Login attribute = (Login) session.getAttribute(session.getId());
        if(attribute == null){
            request.setAttribute("flag","");
        }
        request.setAttribute("flag",attribute.getUserName());
        Order order = couponService.toBackPrice(orderId);
        request.setAttribute("order",order);
        return "yx/toBackPrice";
    }

    //退款（修改）
    @RequestMapping("editOrders")
    @ResponseBody
    public Boolean editOrders(Order order){
        try{
            couponService.editOrders(order);
        }catch (Exception e){
            return false;
        }
        return true;
    }





}
