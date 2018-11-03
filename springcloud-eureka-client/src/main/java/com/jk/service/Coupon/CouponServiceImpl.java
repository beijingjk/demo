package com.jk.service.Coupon;

import com.jk.mapper.Coupon.CouponMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouponServiceImpl implements CouponServiceApi {

    @Autowired
    private CouponMapper couponMapper;



    @Override
    public List<Coupon> queryCouponYxList() {
        return couponMapper.queryCouponYxList();
    }

    @Override
    public List<Coupon> getUsedCouponList() {
        return couponMapper.getUsedCouponList();
    }

    @Override
    public List<Coupon> toExpiredList() {
        return couponMapper.toExpiredList();
    }

    @Override
    public void updateStatus() {
        couponMapper.updateStatus();
    }

    @Override
    public void updateCouponBi(String id, String userId) {
        couponMapper.updateCouponBi(id,userId);
    }

    @Override
    public List<Order> getOrderList(String userId) {
        return couponMapper.getOrderList(userId);
    }

    @Override
    public List<Order> getOrderLists() {
        return couponMapper.getOrderLists();
    }

    @Override
    public List<OrderShipping> getOrderList7() {
        return couponMapper.getOrderList7();
    }

    @Override
    public List<OrderItem> getOrderList8() {
        return couponMapper.getOrderList8();
    }

    @Override
    public List<Order> getOrderList9() {
        return couponMapper.getOrderList9();
    }

    @Override
    public Order toBackPrice(String orderId) {
        return couponMapper.toBackPrice(orderId);
    }

    @Override
    public void editOrders(Order order) {
        couponMapper.editOrders(order);
    }

}
