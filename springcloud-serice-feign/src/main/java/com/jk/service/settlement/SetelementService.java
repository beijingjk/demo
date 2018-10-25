package com.jk.service.settlement;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface SetelementService extends SetelementServiceApi{
}
