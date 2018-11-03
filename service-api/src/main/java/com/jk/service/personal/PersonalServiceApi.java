package com.jk.service.personal;

import com.jk.model.Login;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface PersonalServiceApi {

    @RequestMapping(value = "personal/addLogin",method = RequestMethod.POST)
    void addUser(@RequestBody Login login);

    @RequestMapping(value = "personal/updPassword",method = RequestMethod.GET)
    void updPassword(@RequestBody Login login);
}
