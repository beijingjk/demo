package com.jk.service.Coupon;

import com.jk.model.Order;
import com.jk.model.OrderItem;
import com.jk.model.OrderShipping;
import com.jk.model.Coupon;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface CouponServiceApi {

    @RequestMapping(value = "/yx/queryCouponYxList",method = RequestMethod.GET)
    List<Coupon> queryCouponYxList();

    @RequestMapping(value = "/yx/getUsedCouponList",method = RequestMethod.GET)
    List<Coupon> getUsedCouponList();

    @RequestMapping(value = "/yx/toExpiredList",method = RequestMethod.GET)
    List<Coupon> toExpiredList();

    @RequestMapping(value = "/yx/updateStatus",method = RequestMethod.GET)
    void updateStatus();

    @RequestMapping(value = "/yx/updateCouponBi",method = RequestMethod.POST)
    void updateCouponBi(@RequestParam(value = "id")String id, @RequestParam(value = "userId")String userId);

    @RequestMapping(value = "/yx/getOrderList",method = RequestMethod.GET)
    List<Order> getOrderList(@RequestParam(value = "userId")String userId);

    @RequestMapping(value = "/yx/getOrderLists",method = RequestMethod.GET)
    List<Order> getOrderLists();

    @RequestMapping(value = "/yx/getOrderList7",method = RequestMethod.GET)
    List<OrderShipping> getOrderList7();

    @RequestMapping(value = "/yx/getOrderList8",method = RequestMethod.GET)
    List<OrderItem> getOrderList8();

    @RequestMapping(value = "/yx/getOrderList9",method = RequestMethod.GET)
    List<Order> getOrderList9();

    @RequestMapping(value = "/yx/toBackPrice",method = RequestMethod.GET)
    Order toBackPrice(@RequestParam(value = "orderId")String orderId);

    @RequestMapping(value = "/yx/editOrders",method = RequestMethod.POST)
    void editOrders(@RequestBody Order order);

}
