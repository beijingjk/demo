package com.jk.service.Coupon;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface CouponService extends CouponServiceApi {


}
