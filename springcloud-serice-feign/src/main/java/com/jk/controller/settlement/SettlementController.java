package com.jk.controller.settlement;

import com.jk.model.*;
import com.jk.service.fruitsInfo.FruitsInfoServie;
import com.jk.service.settlement.SetelementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("setelement")
public class SettlementController {

    @Autowired
    private SetelementService setelementService;

    @Autowired
    private FruitsInfoServie fruitsInfoServie;

    @RequestMapping("toSetelement")
    public String toSetelement(ModelMap modelMap,HttpServletRequest request){
        //Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
        //String loginId = login.getLoginId();
        String loginId = "1";
        //商品总价格
        Double num = 0.0;
        DecimalFormat df = new DecimalFormat("#.00");
        //查询购物车列表
        List<FruitsInfo> fruitsInfos1 = fruitsInfoServie.queryCartList(loginId);
        for (FruitsInfo f:fruitsInfos1) {
            Integer amount = f.getAmount();
            BigDecimal price = f.getPrice();
            BigDecimal bigDecimal = new BigDecimal(""+price);
            BigDecimal bigDecimal2 = new BigDecimal(amount.toString());
            num += bigDecimal.multiply(bigDecimal2).doubleValue();
        }
        modelMap.put("fruitsInfo",fruitsInfos1);
        //查询优惠券
        List<Coupon> coupons = fruitsInfoServie.queryConponByUserId(loginId);
        //查询用户地址
        List<Area> areas = setelementService.queryAreaByUserId(loginId);
        modelMap.put("coupon",coupons);
        modelMap.put("areas",areas);
        modelMap.put("num",df.format(num));
        return "setelement/setelement";
    }

    @RequestMapping("toAddAddress")
    public String toAddAddress(){
        return "setelement/addAddress";
    }
    /*
     *  薛长欢
     *
     *  查询省
     */
    @RequestMapping("queryArea")
    @ResponseBody
    public List<Area> queryArea(){
        List<Area> areas = setelementService.queryArea();
        return areas;
    }

    /*
     *  薛长欢
     *
     *  查询市/区
     */
    @RequestMapping("queryAreaByPid")
    @ResponseBody
    public List<Area> queryAreaByPid(Integer pid){
        return setelementService.queryAreaByPid(pid);
    }

    /*
     *  薛长欢
     *
     *  添加地址
     */
    @RequestMapping("addAddress")
    @ResponseBody
    public Boolean addAddress(Area area,HttpServletRequest request){
        try {
            //Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
            //String loginId = login.getLoginId();
            String loginId = "1";
            area.setUserId(Integer.parseInt(loginId));
            setelementService.addAddress(area);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /*
     *  薛长欢
     *
     *  生成订单/之set数据
     */
    @RequestMapping("createOrder")
    @ResponseBody
    public Map<String,Object> createOrder(String receiverAddress,OrderInfo orderInfo,HttpServletRequest request){
        //Login login = (Login) request.getSession().getAttribute(request.getSession().getId());
        //String loginId = login.getLoginId();
        String loginId = "1";
        String name = "张三";
        orderInfo.setUserId(Integer.parseInt(loginId));
        orderInfo.setBuyerNick(name);
        //set地址
        String[] split = receiverAddress.split(",");
        OrderShipping orderShipping = new OrderShipping();
        orderShipping.setReceiverState(split[0]);
        orderShipping.setReceiverCity(split[1]);
        orderShipping.setReceiverDistrict(split[2]);
        if (split.length == 6){
            orderShipping.setReceiverAddress(split[3]);
            orderShipping.setReceiverName(split[4]);
            orderShipping.setReceiverMobile(split[5]);
        }else{
            orderShipping.setReceiverAddress("");
            orderShipping.setReceiverName(split[3]);
            orderShipping.setReceiverMobile(split[4]);
        }
        orderInfo.setOrderShipping(orderShipping);
        //set商品
        //商品总价格
        Double num = 0.0;
        DecimalFormat df = new DecimalFormat("#.00");
        List<FruitsInfo> fruitsInfos = fruitsInfoServie.queryCartList(loginId);
        List<OrderItem> orderItems = new ArrayList<>();
        for (FruitsInfo fruitsInfo:fruitsInfos) {
            OrderItem orderItem = new OrderItem();
            orderItem.setItemId(fruitsInfo.getId());
            orderItem.setNum(fruitsInfo.getAmount());
            orderItem.setPrice(fruitsInfo.getPrice());
            orderItem.setTitle(fruitsInfo.getTitle());
            orderItem.setPicPath(fruitsInfo.getImg1());
            Integer amount = fruitsInfo.getAmount();
            BigDecimal price = fruitsInfo.getPrice();
            BigDecimal bigDecimal = new BigDecimal(""+price);
            BigDecimal bigDecimal2 = new BigDecimal(amount.toString());
            orderItem.setTotalFee(bigDecimal.multiply(bigDecimal2).setScale(2,BigDecimal.ROUND_HALF_UP));
            num += orderItem.getTotalFee().doubleValue();
            orderItems.add(orderItem);
        }
        System.out.println(df.format(num-30));
        orderInfo.setOrderItems(orderItems);
        orderInfo.setPayment(df.format(num-30));
        Map<String, Object> orders = createOrders(orderInfo);
        return orders;
    }
    //创建订单
    private Map<String,Object> createOrders(OrderInfo orderInfo) {
        Map<String,Object> result = setelementService.createOrder(orderInfo);
        System.out.println(result.get("orderId"));
        System.out.println(result.get("payment"));
        return result;
    }
}
