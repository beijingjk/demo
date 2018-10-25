package com.jk.service.Coupon;

import com.jk.mapper.Coupon.CouponMapper;
import com.jk.model.Coupon;
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


}
