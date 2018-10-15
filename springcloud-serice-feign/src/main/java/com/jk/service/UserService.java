package com.jk.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface UserService extends UserServiceApi {

}
