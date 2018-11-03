package com.jk.mapper.personal;

import com.jk.model.FruitsInfo;
import com.jk.model.Login;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonalMapper {


    void addUser(Login login);


    void updPassword(Login login);
}
