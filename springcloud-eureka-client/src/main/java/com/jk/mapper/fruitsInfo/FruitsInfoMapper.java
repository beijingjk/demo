package com.jk.mapper.fruitsInfo;

import com.jk.model.Coupon;
import com.jk.model.FruitsInfo;

import java.util.List;

public interface FruitsInfoMapper {

    /*
     *  薛长欢
     *
     *  根据商品id查询信息
     */
    FruitsInfo queryFruitsInfoById(Integer fruitsId);

    /*
     *  薛长欢
     *
     *  根据登录人id查询优惠券
     */
    List<Coupon> queryConponByUserId(String loginId);

    /*
     *  薛长欢
     *
     *  随机查询三条数据
     */
    List<FruitsInfo> queryFruitsInfoRandom();
}
