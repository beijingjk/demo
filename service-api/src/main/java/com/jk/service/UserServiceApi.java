package com.jk.service;

import com.jk.model.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface UserServiceApi {

    @RequestMapping(value = "user/queryUserName",method = RequestMethod.POST)
    Login queryUserName(@RequestBody Login login);

    @RequestMapping(value = "user/addUser",method = RequestMethod.POST)
    void addUser(@RequestBody Login login);

    @RequestMapping(value = "user/queryUserNameFP",method = RequestMethod.POST)
    Login queryUserNameFP(@RequestBody Login login);

    @RequestMapping(value = "user/getUserByUserPhone",method = RequestMethod.POST)
    Login getUserByUserPhone(String userPhone);

    @RequestMapping(value = "user/queryInthefruit",method = RequestMethod.GET)
    FruitsInfo queryInthefruit();

    @RequestMapping(value = "user/queryInthefruitTwo",method = RequestMethod.GET)
    FruitsInfo queryInthefruitTwo();

    @RequestMapping(value = "user/queryInthefruitTree",method = RequestMethod.GET)
    FruitsInfo queryInthefruitTree();

    @RequestMapping(value = "user/queryGoldenbuttonfruit",method = RequestMethod.GET)
    FruitsInfo queryGoldenbuttonfruit();

    @RequestMapping(value = "user/queryNFCjuice",method = RequestMethod.GET)
    FruitsInfo queryNFCjuice();

    @RequestMapping(value = "user/queryWatermelonmelons",method = RequestMethod.GET)
    FruitsInfo queryWatermelonmelons();

    @RequestMapping(value = "user/queryApplepear",method = RequestMethod.GET)
    FruitsInfo queryApplepear();

    @RequestMapping(value = "user/queryPortugalsmentionofjam",method = RequestMethod.GET)
    FruitsInfo queryPortugalsmentionofjam();

    @RequestMapping(value = "user/queryUserById")
    Login queryUserById(@RequestParam(value = "userId") String userId);
}
