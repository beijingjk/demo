package com.jk.controller;

import com.jk.model.Login;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServiceApi userService;

    @RequestMapping(value = "/queryUserName" ,method = RequestMethod.POST)
    public Login queryUserName(@RequestBody Login login ){
        return userService.queryUserName(login);
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