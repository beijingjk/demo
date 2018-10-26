package com.jk.service.fruitsInfo;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface FruitsInfoServie extends FruitsInfoServieApi{

}
