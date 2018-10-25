package com.jk;

/**
 * 常量类
 * 首次 使用注意下命名规则！
 * @author 红旗
 *
 */

public class ConstantConf {

	/**
	 * 左侧导航树缓存
	 */
	public static final String NAV_POWER = "navPower";


	public static final String LOGIN_CODE = "loginCode";

	public static final String LOGIN_CODE_FLAG = "flag";

	/**
	 * 验证码过期时间
	 */
	public static final Integer LOGIN_CODE_TIME_OUT = 5;
	/**
	 * 天气redis缓存key
	 */
	public static final String WRATHERKEY = "weatherKey";
	/**
	 * 机器人接口地址
	 */
	public static final String ROBOT_URL = "http://api.qingyunke.com/api.php";
	/**
	 * 天气地址
	 */
	public static final String WEATHER_URL = "http://wthrcdn.etouch.cn/weather_mini";
	/**
	 * 根据ip获取城市地址
	 */
	public static final String GET_CITY_IP_URL = "http://ip.taobao.com/service/getIpInfo.php";

	/**
	 * auth_token码
	 */
	public static final String AUTH_TOKEN = "74af9c719efc465d870fe8c518092045";
	/**
	 * 短信模板ID
	 */
	public static final  String TEMPLATE_ID = "516089963";
	/**
	 * 短信平台（秒滴）提供的ID
	 */
	public static final  String ACCOUNT_SID = "69a4bfa2ee4f4ce9ac5b6fc368b24b67";
	/**
	 * 请求 验证码地址
	 */
	public static final String MSG_CODE_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	/**
	 * 安全认证密码
	 */
	public static final String AUTH = "admin";
}
