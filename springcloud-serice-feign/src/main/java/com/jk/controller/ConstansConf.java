/** 
 * <pre>项目名称:network-springboot-consumer 
 * 文件名称:CacheKey.java 
 * 包名:com.jk 
 * 创建日期:2018年9月13日上午8:55:45 
 * Copyright (c) 2018, yuxy123@gmail.com All Rights Reserved.</pre> 
 */  
package com.jk.controller;

public class ConstansConf {
	
	/**
	 *获取短信验证码
	 */
	public static final String SMS_CODE = "smscode";
	
	/** 
	 * 短信平台地址
	 * @version 
	 */
	public static final String SMS_URL = "https://api.miaodiyun.com/20150822/industrySMS/sendSMS";
	
	/** 
	 * 开发者id
	 * @version 
	 */
	public static final String ACCOUNTSID = "85e8679b7c414d3581ff1b39b2ca7d8a";
	
	/** 
	 * 模板id
	 * @version 
	 */
	public static final String TEMPLATEID = "803641846";
	
	/** 
	 * 认证id
	 * @version 
	 */
	public static final String AUTH_TOKEN ="edf5f28cbf354beab30e2f470dfe3fa0";



	// 发件人的邮箱地址和密码
	public static String sendEmailAccount = "2284533017@qq.com";
	//如果有授权码，此处填写授权码
	public static String sendEmailPassword = "ubxkmadylfwgecei";
	// 发件人邮箱的 SMTP 服务器地址, 可以登录web邮箱查询
	public static String sendEmailSMTPHost = "smtp.qq.com";
	// 收件人邮箱地址
	public static String receiveMailAccount = "";
	//发送标题
	public static String sendtitle  = "果鲜生";
	//发送内容
	public static String sendcontent  = "恭喜您已成功注册了果鲜生账户，感谢你对我们平台的支持，请牢记自己注册时填写的信息，祝您购物愉快！";
}
