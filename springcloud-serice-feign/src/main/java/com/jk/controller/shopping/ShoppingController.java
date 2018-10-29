package com.jk.controller.shopping;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.jk.controller.util.AlipayConfig;
import com.jk.model.FruitsInfo;
import com.jk.service.shopping.ShoppingService;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/*
 *  孙丽景
 *
 *  购物车模块
 */
@Controller
@RequestMapping("shopping")
@Component
public class ShoppingController {


    @Autowired
    private ShoppingService shoppingService;
/*@Autowired
    private AmqpTemplate amqpTemplate;*/


    /*
     *  孙丽景
     *
     *  rabbitmq消息队列实现同时发送短信和邮件../shopping/toRabbit
     */
 /*   @RequestMapping("toRabbit*")
    public String toRabbit(){
        String phone = "13603791429";
        String email = "13603791429@163.com";
        this.amqpTemplate.convertAndSend("exchage_topic","topic.info",phone);
        this.amqpTemplate.convertAndSend("exchage_topic","topic.email",email);
        return "shopping/shopping";
    }*/


    /*
     *  孙丽景
     *
     *  支付宝二维码付款../shopping/payOrder
     */
    @RequestMapping("payOrder")
    @ResponseBody
    public String payOrder(String id,String monay,String info,HttpServletRequest request) throws AlipayApiException {

        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);

        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);

        //商户订单号，商户网站订单系统中唯一订单号，必填
        String out_trade_no = id;
        //付款金额，必填
        String total_amount = monay;
        //订单名称，必填
        String subject = "果先生";
        //商品描述，可空
        String body = info;

        alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
                + "\"total_amount\":\""+ total_amount +"\","
                + "\"subject\":\""+ subject +"\","
                + "\"body\":\""+ body +"\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");

        //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
        //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no +"\","
        //		+ "\"total_amount\":\""+ total_amount +"\","
        //		+ "\"subject\":\""+ subject +"\","
        //		+ "\"body\":\""+ body +"\","
        //		+ "\"timeout_express\":\"10m\","
        //		+ "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节

        //请求
        String result = alipayClient.pageExecute(alipayRequest).getBody();
        return result;
    }




    /*
     *  孙丽景
     *
     *  查询大家都在看
     */
    @RequestMapping("queryFruitsInfo")
    @ResponseBody
    public List<FruitsInfo> queryFruitsInfo(){
        List<FruitsInfo> fruitsInfos = shoppingService.queryFruitsInfo();
        return fruitsInfos;
    }




}
