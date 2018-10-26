package com.jk.controller.util;

import java.io.FileWriter;
import java.io.IOException;


public class AlipayConfig {



    //2 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016092000554749";

    //3 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCGMplXlebJlcdjdNvfq4Q267HYoQfJbFdQYhg5O3yUSkvxAkTFrrNjdCYJufCcAFDcP6IUh6eH7K0UZHP7Ek81FEGUqRTdsYmdgbEQ8CBFWd3VB3RYGB5p5OfCKCrVa92E7JxoD0ou4DBKNXhuQIc1CFTvaUR4H8l5lt1gCHFW4JQbugpeeOQFMIuf0462Gtv2rYSw/stVYBcAf47/tIocwf69ZmqnbZREId7+LBcvCP3ZqhAhlp5LZjWTmoaM5IoxMFfnsnuptK3sqiRKur2k+PylD05kihbibaHfAwm52OIW4J37UPT06ykPU4i/m+mxhSlBW1514ToVfWPMvqJBAgMBAAECggEAfGQyl2kvv/PCGoKbvLxzlaTr+W1qll6CoNQMuCBX3ezwb7o2nTbOuYVULPfZ/ACe80lYp8cGl4ve82QZzcSu/viDwZTo7oY+lW0+AAFVKHOgmHKMeYwBxQ6VdPdenO2bLDdW0244yTKuEFt4Alp1+cZ7VGAzQ1XTn40kLnwk8u1kYPqZ/YkRgGl7g99v32anAASV+aTryrIUPcsIUyODRBCL1UR5843dniZMKxioNAVDwRV6CnqQRH2zqOau+3bhE8UAgq+r6zinkuDDlstAP6yMKIYjn5XswCa6gbACkhTRgnWr2VfmpnbkJypQcg259Y2kDhRxAyrSmeJAdltEQQKBgQDbRdAR9p9Dhdmh2mCBoQQ0w2Y6chFkOze8iXFGPdPYTP0qsODK/KKD+heB5DbDne9W29vVu9iwUVSmIfyfEwpFhnH3/WuBww2ViSY39udGnEpqhnS77m8tS5t8rqWpIzWseUfR83TOhT3Q41CwIvaJXPPPIKOrG/mfaMEHwAl2HQKBgQCcrNsS0brZ2prhBFzEkg1WlMdBn2syaQnMBypOxBYrkWrZP/vO3YPoRZLomaBJyYNGtsRal/R3OgORm3qBiRmUPEYrbN0sdVc78OxbE5/atgfx3C3uY7mZLL63IYU5m3pZ1+PiEPr7EkB1BYi9N++cw5YmPp50Dn1EC82PaK2TdQKBgQDAStPyvOXkcEBwCTNy2sL2hpljDd+kl64EYD//Sn86hCHMy3sHaFAZDzyIQ5unJxzafkqmgGrCDUD/xHRnCGqMmB/gS9R44pZKGhFzKMqfiLZV/v3mRW4oOdLsn7hVwLP0QhOy0h8QcZbJVl/PZ4nu4p5JeaUujIT3wATwCAAEHQKBgC3K7AEVIcrY9Rm9n6uokJN0ysRoZvmF7+IdWgVJlL1JNHSpGd09q3cxFp47gLjwWBlMBBoCfeZ3I2HkkqrXuo00DMJWgFKlPUj8wuhf1QIk4C+Vzir2JOIbTObTuk+7HMizrByAIAtQK1zIsE210qf8Fp+4/7EmJwDDfmJjExCdAoGBANnTFmvKvq+caudWOHChj0im2hpiX016sQGsBIcQzxk2fwU9E+BuiDg1XGFsJqBOtgXIwXtDlmMf6pplydoqHI6F3jhFlibo/M0snNek48iO0YvuXPaTprcOp5KMD7BO2UhGLd+OJAQIylWoyDw9B1vT/vt+tg3jIhOHd0f/6ex1";

    //5 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvT3S8OoBpYPpo5pBkyv9cFoEHOKusCe5U57Fa6Cqm8cRg7Q2i5DM8VAaezysOm8g7Q+Sof99gGgBOywfY7FgxqEezDb0O+d4rfF8WT92x7ue57zSBWyEZB188EQ6LcEFVU7LV66dP2YGXOhNCiMrtN7sno2AHNywOZ4y5VrktAAF7rRnbvdTgwgjtkLCwNWn0qQUuUl+rm6n8TtcJ+R+u1rHFh+S2PesJM4hIeD9G78OLvo/ec9RCAAbGLdWDnZzqQk5I/dSLyf+8Mf7fUHCH+4zv4d2dQOvYNwXq49aZ22P2AwVmyssGVmDHYSCRoq7jnOlDvDoJgw7VGK8NtoKCwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8084/springcloud-serice-feign/notify_url.jsp";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
//	public static String return_url = "http://localhost:8080/success";
    public static String return_url = "http://localhost:8084/fruitsInfo/toShoppingCar";

    //6 签名方式
    public static String sign_type = "RSA2";

    //4 字符编码格式
    public static String charset = "utf-8";

    //1 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "F:/";




    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

