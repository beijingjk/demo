package com.jk.controller;

import com.jk.ConstantConf;
import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.service.UserServiceApi;
import com.jk.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;


    //葡提果酱
    @RequestMapping("queryPortugalsmentionofjam")
    @ResponseBody
    public FruitsInfo queryPortugalsmentionofjam(){
        FruitsInfo Portugalsmentionofjam =userService.queryPortugalsmentionofjam();
        return Portugalsmentionofjam;
    }

    //苹果梨子
    @RequestMapping("queryApplepear")
    @ResponseBody
    public FruitsInfo queryApplepear(){
        FruitsInfo apple =userService.queryApplepear();
        return apple;
    }

    //西瓜蜜瓜
    @RequestMapping("queryWatermelonmelons")
    @ResponseBody
    public FruitsInfo queryWatermelonmelons(){
        FruitsInfo Watermel =userService.queryWatermelonmelons();
        return Watermel;
    }

    //NFC果汁查询
    @RequestMapping("queryNFCjuice")
    @ResponseBody
    public FruitsInfo queryNFCjuice(){
        FruitsInfo importfruit =userService.queryNFCjuice();
        return importfruit;
    }

    //进口水果查询
    @RequestMapping("queryGoldenbuttonfruit")
    @ResponseBody
    public FruitsInfo queryGoldenbuttonfruit(){
        FruitsInfo importfruit =userService.queryGoldenbuttonfruit();
        return importfruit;
    }


    //当季水果第三个查询
    @RequestMapping("queryInthefruitTree")
    @ResponseBody
    public FruitsInfo queryInthefruitTree(){
        FruitsInfo three =userService.queryInthefruitTree();
        return three;
    }


    //当季水果第二个查询
    @RequestMapping("queryInthefruitTwo")
    @ResponseBody
    public FruitsInfo queryInthefruitTwo(){
        FruitsInfo two=userService.queryInthefruitTwo();
        return two;
    }


    //当季水果第一个查询
    @RequestMapping("queryInthefruit")
    @ResponseBody
    public FruitsInfo queryInthefruit(){
        FruitsInfo put=userService.queryInthefruit();
        return put;
    }

    //新品上市页面跳转
    @RequestMapping("toXin")
    public String toXin(){
        return "newArrival";
    }

    //限时折扣页面跳转
    @RequestMapping("toxianShi")
    public String toxianShi(){
        return "secakill";
    }

    //人气果王页面跳转
    @RequestMapping("toRen")
    public String toRen(){
        return "moods";
    }

    //商品详情页面跳转
    @RequestMapping("toXiangQing")
    public String toXiangQing(){
        return "savedResource";
    }

    //select.html
    @RequestMapping("toSelect")
    public String toSelect(){
        return "select";
    }

    //@Autowired
    //private RedisTemplate<String, String> redisTmeplate;

    @RequestMapping("toIndex")
    public String toIndex(){ return "index"; }

    @RequestMapping("toLogin")
    public String toLogin(){
        return "login/login";
    }

    @RequestMapping("toRegister")
    public String toRegister(){
        return "login/register";
    }

    @RequestMapping("toLogin2")
    public String toLogin2(){
        return "demo";
    }

    @RequestMapping("toRegister2")
    public String toRegister2(){
        return "register2";
    }

    //跳转忘记密码页面
    @RequestMapping("toForgetPwd")
    public String toForgetPwd(){
        return "forget/demo";
    }

    /**
      * 调往忘记密码页面
      * @author xushuanglu
      * @date 2016年6月21日
      */
    @RequestMapping("toFindPass")
    public String toFindPass(){
        return "login/forget";
    }

   /* *//**
      * 忘记密码下一步
      * @param phone   手机号
      * @param code    验证码
      * @param phonecode   手机短信验证码
      * @author xushuanglu
      * @date 2016年6月21日
      *//*
    @RequestMapping("toValidate")
    public String toValidate(ModelMap model, String phone, String imgCode, String phonecode, HttpServletRequest request, HttpServletResponse response) {
        // 后台验证  通过手机号查询用户信息
        Login login = userService.getByPhone(phone);
        String result = backgroundValidate(phone,imgCode,phonecode,login);
        if (result !=null) {
            error(result,request,response);
            return null;
        }
        request.getSession().setAttribute("resetUserId",login.getUserId());
        model.addAttribute("hjsUsersCustomer",login);// 用户信息
        return "resetPassWord";
    }

    private String backgroundValidate(String phone, String code, String phonecode, Login login) {
        String result = null;
        // 判断用户信息是否存在
        if (login == null) {
            return result = "用户信息不存在或者用户已经停用，请与客服联系";
        }

        // 手机验证码
        if (getSession().getAttribute("passCode") != null) {
            String codeString = getSession().getAttribute("passCode").toString();
            Date codeTime =(Date) getSession().getAttribute("passTime");
            String phoneString = getSession().getAttribute("passPhone").toString();
            long diff =(new Date().getTime() - codeTime.getTime()) /(1000 * 60);
            if (!codeString.equals(phonecode) || diff >30 || !phoneString.equals(login.getUserPhone())){
                return result ="手机校验码不正确";
            } else {
                getSession().removeAttribute("passCode");
            }
        }


        // 验证码
        if (ValidateUtils.isStringEmpty()) {
            return result ="请输入验证码";
        }

        if(!getSession().getAttribute(Const.SESSION_SECURITY_CODE).toString().equalsIgnoreCase(code)) {
            return result ="验证码不正确";
        }
            return result;
    }


    *//**
      * 修改密码
      * @param newPass   新密码
      * @author xushuanglu
      * @date 2016年6月21日
      *//*
    @RequestMapping("resetPass")
    public String editPass(ModelMap model, String newPass,HttpServletRequest request, HttpServletResponse response) {
        HashMap<String, Object> result = new HashMap<String, Object>();
            //后台验证
            if (ValidateUtils.isStringEmpty()) {
                result.put("请填写新密码","request","response");
                return null;
            }

            if (request.getSession().getAttribute("resetUserId") ==null) {
                result.put("重设密码失败，请稍后再试","request","response");
            return null;
            }

            Integer userId = (Integer)getSession().getAttribute("resetUserId");
            getSession().setAttribute("resetUserId",null);
            Login login = userService.getById(userId);
            newPass = new SimpleHash("SHA-1",usersCustomer.getUsername(),newPass).toString();//密码加密
            usersCustomer.setPassword(newPass);

            //更新密码
            usersCustomerService.update(usersCustomer);
            return "redirect:login";

    }*/

    @RequestMapping("getVerify")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {
        try {
            response.setContentType("image/jpeg");//设置相应类型,告诉浏览器输出的内容为图片
            response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();
            randomValidateCode.getRandcode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            //*logger.error("获取验证码失败>>>>   ", e);*//*
        }
    }

    @RequestMapping("userLogin")
    @ResponseBody
    public HashMap<String, Object> userLogin(Login login, String imgCode, HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        String sessionCode = session.getAttribute("RANDOMVALIDATECODEKEY").toString();
        if (!sessionCode.equals(imgCode)) {
            result.put("code", 1);
            result.put("msg", "验证码错误");
            return result;
        }
        String loginNumber = login.getUserName();
        Login userLogin = userService.queryUserName(login);
        if (userLogin == null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;
        }
        String password = login.getUserPassword();
        String md516 = MD5Utils.encrypt(password);
        System.out.println(md516);
        if (!userLogin.getUserPassword().equals(md516)) {
            result.put("code", 3);
            result.put("msg", "密码错误");
            return result;
        }
        session.setAttribute(session.getId(), userLogin);
        result.put("code", 0);
        result.put("msg", "登录成功");
        return result;
    }

    /**
     * 注册方法,注册时对密码进行 MD5算法加密
     * @param user
     * @return
                    */
        @RequestMapping("addUser")
        @ResponseBody
        public Boolean addUser(Login login,HttpServletRequest request){
            //密码加密并set
        login.setUserPassword(MD5Utils.encrypt(login.getUserPassword()));
        try{
            userService.addUser(login);//将用户数据插入数据库
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        validateMsg(login.getUserPhone());
        return true;
    }

    /**
     * 忘记密码第一步
     * @return
     */
    private void validateMsg(String userPhone) {
        HashMap<String, Object> param = new HashMap<>();
        String timestamp = TimeUtil.timeFormat(new Date());
        Random random = new Random();
        String str  = "";
        for (int i = 0; i < 6; i++) {
            int nextInt = random.nextInt(10);
            str += String.valueOf(nextInt);
        }
        param.put("accountSid", ConstantConf.ACCOUNT_SID);
        param.put("templateid", ConstantConf.TEMPLATE_ID);
        param.put("param", str);
        param.put("to", userPhone);
        param.put("timestamp", timestamp);
        param.put("sig", Md5Util.getMd532(ConstantConf.ACCOUNT_SID+ConstantConf.AUTH_TOKEN+timestamp));
        HttpClientUtil.post(ConstantConf.MSG_CODE_URL, param);
    }

    /*@RequestMapping("queryForgetPwd")
    public HashMap<String, Object> queryForgetPwd(Login login, String imgCode, HttpServletRequest request){
        HashMap<String, Object> result = new HashMap<String, Object>();
        HttpSession session = request.getSession();
        String sessionCode = session.getAttribute("RANDOMVALIDATECODEKEY").toString();
        if (!sessionCode.equals(imgCode)) {
            result.put("code", 1);
            result.put("msg", "验证码错误");
        }
        String loginNumber = login.getUserName();
        System.out.println(loginNumber);
        Login userLogin = userService.queryUserNameFP(login);
        if (userLogin == null) {
            result.put("code", 2);
            result.put("msg", "账号不存在");
            return result;
        }
        return result;
    }
*/
    @RequestMapping("toLayout")
    public String toLayout(){
        return "login/main";
    }


   @RequestMapping("已使用.html")
    public String toLayout1(){
        return "yx/toGetUsed";
    }


    @RequestMapping("首页.html")
    public String toLayout2(){
        return "index";
    }

    @RequestMapping("优惠券-未使用.html")
    public String toLayout3(){
        return "yx/Coupon";
    }

}
