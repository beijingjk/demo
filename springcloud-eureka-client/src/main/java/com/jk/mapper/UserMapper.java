package com.jk.mapper;

import com.jk.model.Login;
import com.jk.model.PetType;
import com.jk.model.Tree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface UserMapper {

    Login queryUserName(String userName);

    void addUser(Login login);

    Login queryUserNameFP(String userName);

    @Select(" select * from t_user where userPhone=#{userPhone} ")
    Login getUserByUserPhone(Login login);
}
