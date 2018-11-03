package com.jk.service.fruits;

import com.jk.model.FruitsInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface FruitsServiceApi {

    /*
     *  孙丽景
     *
     *  solr查询
     */
    @RequestMapping("fruits/SearchFruits")
    List<FruitsInfo> SearchFruits(@RequestParam(value = "title") String title);
}
