package com.json.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.json.Json.dto.JsonRequestDto;
import com.json.Json.service.JsonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("json/")
public class JsonController {

    @Autowired
    JsonService jsonService;

    @PostMapping("standin")
    public void jsonStandin(@RequestBody JsonRequestDto requestDto) throws JsonProcessingException {
        jsonService.enviaJsonStandin(requestDto);
    }

    @PostMapping("conta")
    public void jsonConta(@RequestBody JsonRequestDto requestDto) throws JsonProcessingException {
        jsonService.enviaJsonContaCorrente(requestDto);
    }

    @PostMapping("recebe")
    public void jsonRecebe(@RequestBody JsonRequestDto requestDto) throws JsonProcessingException {
        jsonService.recebeJson(requestDto);
    }

}
