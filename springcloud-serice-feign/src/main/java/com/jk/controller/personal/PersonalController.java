package com.jk.controller.personal;


import com.jk.model.Login;
import com.jk.service.personal.PersonalServiceApi;
import com.jk.util.MD5Utils;
import com.jk.util.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("personal")
public class PersonalController {

    @Autowired
    private PersonalServiceApi personalService;

    @RequestMapping("toPersonal")
    public String toPersonal(){
        return "personal";
    }

    @RequestMapping("toAccount")
    public String toAccount(){
        return "account";
    }

    @RequestMapping("toAddress")
    public String toAddress(){
        return "address";
    }

    @RequestMapping("upImg")
    @ResponseBody
    public String upImg(MultipartFile artImg, HttpServletRequest req) throws Exception {
        // 获取原文件名称
        String fileName = artImg.getOriginalFilename();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String folderPath = req.getSession().getServletContext().getRealPath("/") + "upload/";
        File file = new File(folderPath);
        // 该目录是否已经存在
        if (!file.exists()) {
            // 创建文件夹
            file.mkdir();
        }
        String onlyFileName = sdf.format(new Date()) + fileName.substring(fileName.lastIndexOf('.'));
        FileOutputStream fos = new FileOutputStream(folderPath + onlyFileName);
        fos.write(artImg.getBytes());
        fos.flush();
        fos.close();
        return "upload/" + onlyFileName;
    }
    @RequestMapping("addUser")
    @ResponseBody
    public Boolean addUser(Login login){
        try{
            personalService.addUser(login);
        }catch (Exception e){
            return false;
        }
        return true;
    }
    @RequestMapping("toUpdPassWord")
    public String toUpdPassWord(){
        return "updPassWord";
    }

    @RequestMapping("updPassword")
    @ResponseBody
    public Map<String,Object> updPassword(Login login,String yuanpws,String onepwd, HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();

        HttpSession session = request.getSession();
        Login user = (Login) session.getAttribute(session.getId());
            String userPassword = user.getUserPassword();
            String encrypt = MD5Utils.encrypt(yuanpws);

            if(!userPassword.equals(encrypt)){
                //原密码不正确
                result.put("code","1");
                return result;
            }
            if(!onepwd.equals(login.getUserPassword())){
                //两次密码不一致
                result.put("code","2");
                return result;
            }

                String encrypt2 = MD5Utils.encrypt(login.getUserPassword());
                login.setUserPassword(encrypt2);
                login.setUserId(user.getUserId());
                personalService.updPassword(login);
                result.put("code","0");
                return result;

    }

}
