package com.jk.service;

import com.jk.model.PetType;
import com.jk.model.Tree;
import com.jk.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;


public interface UserServiceApi {
    @RequestMapping(value = "/user/getUserInfo",method = RequestMethod.GET)
    User sayHiFromClientOne(@RequestParam(value = "userName") String name);

    @RequestMapping(value = "user/queryTree",method = RequestMethod.GET)
    List<Tree> queryTree();

    @RequestMapping(value = "user/queryPetTypePage",method = RequestMethod.GET)
    List<PetType> queryPetTypePage();

    @DeleteMapping("/user/delPet/{ptid}")
    void delPet(@PathVariable("ptid")String ptid);

    @PostMapping("/user/savePet")
    void savePet(@RequestBody PetType petType);

    @RequestMapping(value = "/user/toeditByPid",method = RequestMethod.GET)
    PetType toeditByPid(@RequestParam(value = "ptid") String ptid);


    @RequestMapping(value = "/user/toeditByPid",method = RequestMethod.GET)
    PetType toedit(@RequestParam(value = "ptid") String ptid);



    @PutMapping("/user/updatePet")
    void updatePet(@RequestBody PetType petType);
}
