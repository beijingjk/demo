package com.jk.controller;

import com.jk.model.PetType;
import com.jk.model.Tree;
import com.jk.model.User;
import com.jk.service.UserServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServiceApi userService;


    @RequestMapping(value = "sayHello")
    public User sayHello(@RequestParam String name){

        return userService.sayHiFromClientOne(name);
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
    @RequestMapping("delPet")
    @ResponseBody
    public String delPet(String ptid){
        userService.delPet(ptid);
        return  "{}";
    }
    @RequestMapping("savePet")
    @ResponseBody
    public String savePet( PetType petType){

        petType.setPtid( UUID.randomUUID().toString().replaceAll("-", ""));
        userService.savePet(petType);
        return  "{}";
    }
    @RequestMapping("toeditById")
    public PetType toeditById(@RequestParam String ptid, HttpServletRequest request){
        return  userService.toedit(ptid);
    }
    @RequestMapping("@RequestBody updatePet")
    @ResponseBody
    public String updatePet(PetType petType){
        userService.updatePet(petType);
        return  "{}";
    }
}
