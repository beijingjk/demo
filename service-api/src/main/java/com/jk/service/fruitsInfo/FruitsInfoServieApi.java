package com.jk.service.fruitsInfo;

import com.jk.model.Coupon;
import com.jk.model.FruitsInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface FruitsInfoServieApi {

    /*
     *  薛长欢
     *
     *  根据商品id查询信息
     */
    @RequestMapping("fruitsInfo/queryFruitsInfoById")
    FruitsInfo queryFruitsInfoById(@RequestParam(value = "fruitsId") Integer fruitsId);

    /*
     *  薛长欢
     *
     *  根据登录人id查询优惠券
     */
    @RequestMapping("fruitsInfo/queryConponByUserId")
    List<Coupon> queryConponByUserId(@RequestParam(value = "loginId")String loginId);

    /*
     *  薛长欢
     *
     *  随机查询三条数据
     */
    @RequestMapping("fruitsInfo/queryFruitsInfoRandom")
    List<FruitsInfo> queryFruitsInfoRandom();

    /*
     *  薛长欢
     *
     *  加入购物车
     */
    @RequestMapping("fruitsInfo/addCart")
    Map<String, Object> addCart(@RequestParam(value = "loginId")String loginId, @RequestParam(value = "fruitsId")Integer fruitsId, @RequestParam(value = "num")Integer num);

    /*
     *  薛长欢
     *
     *  查询购物车列表
     */
    @RequestMapping("fruitsInfo/queryCartList")
    List<FruitsInfo> queryCartList(@RequestParam(value = "loginId") String loginId);

    /*
     *  薛长欢
     *
     *  删除购物车商品
     */
    @RequestMapping("fruitsInfo/deleteCart")
    void deleteCart(@RequestParam("loginId") String loginId, @RequestParam("fruitsId") Integer fruitsId);

    /*
     *  薛长欢
     *
     *  清空购物车 根据登录id
     */
    @RequestMapping("fruitsInfo/deleteAllCart")
    void deleteAllCart(@RequestParam("loginId")String loginId);

    /*
     *  薛长欢
     *
     *  修改购物车
     */
    @RequestMapping("fruitsInfo/updateCart")
    void updateCart(@RequestParam(value = "loginId")String loginId, @RequestParam(value = "fruitsId")Integer fruitsId, @RequestParam(value = "num")Integer num);
}
