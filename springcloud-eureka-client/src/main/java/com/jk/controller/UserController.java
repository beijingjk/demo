package com.jk.controller;

import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserService;
import com.jk.service.UserServiceApi;
import com.jk.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/queryUserName" ,method = RequestMethod.POST)
    public Login queryUserName(@RequestBody Login login ){
        return userService.queryUserName(login.getUserName());
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public Boolean addUser(@RequestBody Login login){
        try{
            userService.addUser(login);//将用户数据插入数据库
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}