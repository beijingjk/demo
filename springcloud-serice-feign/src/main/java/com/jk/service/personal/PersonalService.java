package com.jk.service.personal;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface PersonalService extends PersonalServiceApi{
}
