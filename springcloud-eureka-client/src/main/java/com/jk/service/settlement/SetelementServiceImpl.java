package com.jk.service.settlement;

import com.jk.mapper.settlement.SetelementMapper;
import com.jk.model.Area;
import com.jk.model.OrderInfo;
import com.jk.model.OrderItem;
import com.jk.model.OrderShipping;
import com.jk.util.OrderNumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SetelementServiceImpl implements SetelementServiceApi{

    @Autowired
    private SetelementMapper setelementMapper;

    /*
     *  薛长欢
     *
     *  查询省
     */
    @Transactional(readOnly = true)
    @Override
    public List<Area> queryArea() {
        return setelementMapper.queryArea();
    }

    /*
     *  薛长欢
     *
     *  查询市/区
     */
    @Transactional(readOnly = true)
    @Override
    public List<Area> queryAreaByPid(Integer pid) {
        return setelementMapper.queryAreaByPid(pid);
    }

    @Override
    public void addAddress(Area area) {
        setelementMapper.addAddress(area);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Area> queryAreaByUserId(String loginId) {
        return setelementMapper.queryAreaByUserId(loginId);
    }

    @Override
    public Map<String, Object> createOrder(OrderInfo orderInfo) {
        //生成订单id
        String orderId = OrderNumberUtils.getOrderIdByUUId();
        //补全orderInfo的属性
        orderInfo.setOrderId(orderId);
        //1、未付款，2、已付款，3、未发货，4、已发货，5、交易成功，6、交易关闭
        orderInfo.setStatus(2);
        orderInfo.setCreateTime(new Date());
        orderInfo.setUpdateTime(new Date());
        //向订单表插入数据
        setelementMapper.insertOrder(orderInfo);
        List<OrderItem> orderItems = orderInfo.getOrderItems();
        for (OrderItem orderItem:orderItems) {
            orderItem.setOrderId(orderId);
        }
        //向订单商品表插入数据
        setelementMapper.insertOrderItem(orderItems);
        //向订单物流表插入数据
        OrderShipping orderShipping = orderInfo.getOrderShipping();
        orderShipping.setOrderId(orderId);
        orderShipping.setCreated(new Date());
        orderShipping.setUpdated(new Date());
        setelementMapper.insertOrderShipping(orderShipping);
        Map<String, Object> result = new HashMap<>();
        //订单id
        result.put("orderId",orderId);
        //订单金额
        result.put("payment",orderInfo.getPayment());
        return result;
    }
}
