package com.jk.mapper;

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


    List<Tree> queryTree();

    List<PetType> queryPetTypePage();

    void delPet(@Param("ptid") String ptid);

    void savePet(@RequestBody PetType petType);

    PetType toeditByPid(@Param("ptid") String ptid);

    void updatePet(@RequestBody PetType petType);
}
