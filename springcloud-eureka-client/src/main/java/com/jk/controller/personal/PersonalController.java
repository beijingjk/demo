package com.jk.controller.personal;

import com.jk.model.Login;
import com.jk.service.personal.PersonalServiceApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@RequestMapping("personal")
@Controller
public class PersonalController {

    @Autowired
    private PersonalServiceApi personalService;

    @RequestMapping("addLogin")
    @ResponseBody
    public void addLogin(@RequestBody Login login){
        personalService.addUser(login);
    }

    @RequestMapping("updPassword")
    @ResponseBody
    public void updPassword(@RequestBody Login login){
        personalService.updPassword(login);
    }

}
