package com.jk.mapper.settlement;

import com.jk.model.*;

import java.util.List;

public interface SetelementMapper {

    /*
     *  薛长欢
     *
     *  查询省
     */
    List<Area> queryArea();

    /*
     *  薛长欢
     *
     *  查询市/区
     */
    List<Area> queryAreaByPid(Integer pid);

    /*
     *  薛长欢
     *
     *  添加地址
     */
    void addAddress(Area area);

    /*
     *  薛长欢
     *
     *  查询用户地址
     */
    List<Area> queryAreaByUserId(String loginId);

    /*
     *  薛长欢
     *
     *  订单表
     */
    void insertOrder(Order orders);

    /*
     *  薛长欢
     *
     *  向订单商品表插入数据
     */
    void insertOrderItem(List<OrderItem> orderItems);

    /*
     *  薛长欢
     *
     *  向订单物流表插入数据
     */
    void insertOrderShipping(OrderShipping orderShipping);
}
