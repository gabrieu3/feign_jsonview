package com.json.Json.client;

import com.json.Json.config.FeignConfig;
import com.json.Json.dto.JsonRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "JsonFeign", url = "http://localhost:8888/json/", configuration = FeignConfig.class)
public interface JsonClient {
    @RequestMapping(method = RequestMethod.POST, value = "/recebe", consumes = "application/json")
    void send(JsonRequestDto dto);
}
