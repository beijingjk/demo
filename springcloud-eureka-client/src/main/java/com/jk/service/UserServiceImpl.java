package com.jk.service;

import com.jk.mapper.UserMapper;
import com.jk.model.PetType;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServiceApi {

    @Autowired
    private  UserMapper userMapper;

    @Override
    public User sayHiFromClientOne(String name) {
        return null;
    }

    @Override
    public List<Tree> queryTree() {
        return userMapper.queryTree();
    }

    @Override
    public List<PetType> queryPetTypePage() {

        return userMapper.queryPetTypePage();
    }

    @Override
    public void delPet(String ptid) {
        userMapper.delPet(ptid);
    }

    @Override
    public void savePet(PetType petType) {
        userMapper.savePet(petType);
    }

    @Override
    public PetType toeditByPid(String ptid) {
        return userMapper.toeditByPid(ptid);
    }

    @Override
    public PetType toedit(String ptid) {
        return null;
    }

    @Override
    public void updatePet(PetType petType) {
        userMapper.updatePet(petType);
    }
}
