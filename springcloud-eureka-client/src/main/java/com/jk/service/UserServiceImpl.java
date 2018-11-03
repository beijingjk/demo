package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServiceApi{

    @Autowired
    private  UserMapper userMapper;

    @Override
    public Login queryUserName(Login login) {
        return userMapper.queryUserName(login.getUserName());
    }

    @Override
    public void addUser(Login login) {
        userMapper.addUser(login);
    }

    @Override
    public Login queryUserNameFP(Login login) {
        return userMapper.queryUserNameFP(login.getUserName());
    }

    @Override
    public Login getUserByUserPhone(String userPhone) {
        Login login = new Login();
        login.setUserPhone(userPhone);
        return userMapper.getUserByUserPhone(login);
    }

    @Override
    public FruitsInfo queryInthefruit() {
        return userMapper.queryInthefruit();
    }

    @Override
    public FruitsInfo queryInthefruitTwo() {
        return userMapper.queryInthefruitTwo();
    }

    @Override
    public FruitsInfo queryInthefruitTree() {
        return userMapper.queryInthefruitTree();
    }

    @Override
    public FruitsInfo queryGoldenbuttonfruit() {
        return userMapper.queryGoldenbuttonfruit();
    }

    @Override
    public FruitsInfo queryNFCjuice() {
        return userMapper.queryNFCjuice();
    }

    @Override
    public FruitsInfo queryWatermelonmelons() {
        return userMapper.queryWatermelonmelons();
    }

    @Override
    public FruitsInfo queryApplepear() {
        return userMapper.queryApplepear();
    }

    @Override
    public FruitsInfo queryPortugalsmentionofjam() {
        return userMapper.queryPortugalsmentionofjam();
    }

    @Override
    public Login queryUserById(String userId) {
        return userMapper.queryUserById(userId);
    }

    /*@Override
    @RequestMapping(value = "queryUserName")
    public Login queryUserName(@RequestBody Login login) {
        return userMapper.queryUserName(login.getUserName());
    }
*/


}
