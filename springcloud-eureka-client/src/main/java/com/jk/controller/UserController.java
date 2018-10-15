package com.jk.controller;

import com.jk.model.PetType;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;


    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "getUserInfo",method = RequestMethod.GET)
    public User getUserInfo(@RequestParam String userName){
        User user=new User();
        user.setUserId(Integer.parseInt(serverPort));
        user.setUserName("李四");
        user.setUserDate(new Date());
        user.setUserSex(1);
        return user;
    }


    @RequestMapping("toqueryTree")
    public String toqueryTree(){

        return "index";
    }

    @RequestMapping("queryTree")
    @ResponseBody
    public List<Tree> queryTree(){
        List<Tree> list=userService.queryTree();
        return  list;
    }
    @RequestMapping("toShowPet")
    public String toShowPet(){
        return "showPetType";
    }
    @RequestMapping("queryPetTypePage")
    @ResponseBody
    public List<PetType> queryPetTypePage(){
        List<PetType> list=userService.queryPetTypePage();
        return  list;
    }
    @DeleteMapping("/delPet/{ptid}")
    @ResponseBody
    public String delPet(@PathVariable("ptid")String ptid){
        userService.delPet(ptid);
        return  "{}";
    }
    @RequestMapping("savePet")
    @ResponseBody
    public String savePet(@RequestBody PetType petType){
        userService.savePet(petType);
        return  "{}";
    }
    @RequestMapping(value = "toeditByPid",method = RequestMethod.GET)
    public PetType toeditByPid(@RequestParam String ptid){

        PetType petType=userService.toeditByPid(ptid);

        return petType;
    }
    @RequestMapping("updatePet")
    @ResponseBody
    public String updatePet(@RequestBody PetType petType){
        userService.updatePet(petType);
        return  "{}";
    }




}
