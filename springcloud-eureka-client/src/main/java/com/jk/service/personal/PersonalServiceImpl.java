package com.jk.service.personal;

import com.jk.mapper.personal.PersonalMapper;
import com.jk.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class PersonalServiceImpl implements PersonalServiceApi{

    @Autowired
    private PersonalMapper personalMapper;

    @Override
    public void addUser(Login login) {
        personalMapper.addUser(login);
    }

    @Override
    public void updPassword(Login login,String id) {

        personalMapper.updPassword(login,id);
    }
}
