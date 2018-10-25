package com.jk.controller.util;

import com.jk.controller.ConstansConf;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/*
 *  孙丽景
 *
 *  发送短信
 */
@Component
@RabbitListener(queues = "topic_1")
public class Receive1 {

    @RabbitHandler
    public void process(String hello){


        HashMap<String, Object> params = new HashMap<>();
        params.put("accountSid", ConstansConf.ACCOUNTSID);
        params.put("templateid", ConstansConf.TEMPLATEID);
        params.put("to", hello);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String time = simpleDateFormat.format(new Date());
        params.put("timestamp", time);
        String sig = Md5Util.getMd532(ConstansConf.ACCOUNTSID + ConstansConf.AUTH_TOKEN + time);
        params.put("sig",sig);
        HttpClientUtil.post(ConstansConf.SMS_URL, params );



        System.out.println("发送短信:" + hello);
    }
}
