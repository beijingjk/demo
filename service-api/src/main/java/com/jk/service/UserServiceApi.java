package com.jk.service;

import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface UserServiceApi {

    @RequestMapping(value = "queryUserName",method = RequestMethod.POST)
    Login queryUserName(@RequestBody Login login);

    @RequestMapping(value = "addUser",method = RequestMethod.POST)
    void addUser(@RequestBody Login login);

    @RequestMapping(value = "queryUserNameFP",method = RequestMethod.POST)
    Login queryUserNameFP(@RequestBody Login login);

    @RequestMapping(value = "getUserByUserPhone",method = RequestMethod.POST)
    Login getUserByUserPhone(String userPhone);
}
