package com.jk.service.shopping;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "service-hi")
public interface ShoppingService extends ShoppingServiceApi{
}
