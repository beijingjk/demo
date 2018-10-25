package com.jk.service.Coupon;

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

}
