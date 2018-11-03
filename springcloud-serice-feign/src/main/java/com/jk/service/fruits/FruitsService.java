package com.jk.service.fruits;

import com.jk.service.fruitsInfo.FruitsInfoServieApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface FruitsService extends FruitsServiceApi{

}
