package com.jk.controller;

import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;


    //根据用户id查询用户信息
    @RequestMapping("queryUserById")
    @ResponseBody
    public Login queryUserById(@RequestParam String userId){
        return userService.queryUserById(userId);
    }


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


    @RequestMapping(value = "/queryUserName" ,method = RequestMethod.POST)
    @ResponseBody
    public Login queryUserName(@RequestBody Login login ){
        return userService.queryUserName(login);
    }

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
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