package com.jk.controller.personal;


import com.jk.model.Login;
import com.jk.service.personal.PersonalServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

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
    public void addUser(Login login){
        personalService.addUser(login);
    }
    @RequestMapping("toUpdPassWord")
    public String toUpdPassWord(){
        return "updPassWord";
    }

    @RequestMapping("updPassword")
    @ResponseBody
    public void updPassword(Login login,HttpServletRequest request){

        Login user= (Login) request.getSession().getAttribute("login");

        String id=user.getUserId();

        personalService.updPassword(login,id);
    }

}
