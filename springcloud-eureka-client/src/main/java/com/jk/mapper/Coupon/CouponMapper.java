package com.jk.mapper.Coupon;

import com.jk.model.Coupon;
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

}
