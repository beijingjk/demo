package com.jk.service.settlement;

import com.jk.model.Area;
import com.jk.model.OrderInfo;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface SetelementServiceApi {
    /*
     *  薛长欢
     *
     *  查询省
     */
    @RequestMapping("element/queryArea")
    List<Area> queryArea();

    /*
     *  薛长欢
     *
     *  查询市/区
     */
    @RequestMapping("element/queryAreaByPid")
    List<Area> queryAreaByPid(@RequestParam(value = "pid") Integer pid);

    /*
     *  薛长欢
     *
     *  添加地址
     */
    @RequestMapping("element/addAddress")
    void addAddress(@RequestBody Area area);

    /*
     *  薛长欢
     *
     *  查询用户地址
     */
    @RequestMapping("element/queryAreaByUserId")
    List<Area> queryAreaByUserId(@RequestParam(value = "loginId") String loginId);

    /*
     *  薛长欢
     *
     *  创建订单
     */
    @RequestMapping("element/createOrder")
    Map<String, Object> createOrder(@RequestBody OrderInfo orderInfo);
}
