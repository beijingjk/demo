package com.jk.mapper.Coupon;

import com.jk.model.*;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface CouponMapper {


    List<Coupon> queryCouponYxList();

    List<Coupon> getUsedCouponList();

    List<Coupon> toExpiredList();

    void updateStatus();


    void updateCouponBi(@Param("id")String id,@Param("userId") String userId);

    List<Order> getOrderList(@Param("userId")String userId);

    List<Order> getOrderLists();

    List<OrderShipping> getOrderList7();

    List<OrderItem> getOrderList8();

    List<Order> getOrderList9();

    Order toBackPrice(@Param("orderId")String orderId);

    void editOrders(@Param("o")Order order);
}
