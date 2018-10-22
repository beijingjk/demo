package com.jk.service.shopping;

import com.jk.model.FruitsInfo;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public interface ShoppingServiceApi {

    @RequestMapping(value = "/shopp/queryFruitsInfo")
    List<FruitsInfo> queryFruitsInfo();



}
