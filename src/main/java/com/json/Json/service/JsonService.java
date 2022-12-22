package com.json.Json.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.Json.client.JsonClient;
import com.json.Json.dto.JsonRequestDto;
import com.json.Json.view.JsonViews;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class JsonService {

    @Autowired
    private JsonClient jsonClient;

    public void enviaJsonStandin(JsonRequestDto requestDto) throws JsonProcessingException {
        log.info("Inicio enviaJsonStandin");
        log.info(new ObjectMapper().writerWithView(JsonViews.Standin.class).writeValueAsString(requestDto));
        jsonClient.send(requestDto);
        log.info("Fim enviaJsonStandin");
    }

    public void enviaJsonContaCorrente(JsonRequestDto requestDto) throws JsonProcessingException {
        log.info("Inicio enviaJsonContaCorrente");
        log.info(new ObjectMapper().writerWithView(JsonViews.Conta.class).writeValueAsString(requestDto));
        jsonClient.send(requestDto);
        log.info("Fim enviaJsonContaCorrente");
    }

    public void recebeJson(JsonRequestDto requestDto) throws JsonProcessingException {
        log.info("Inicio recebeJson");
        log.info(new ObjectMapper().writeValueAsString(requestDto));
        log.info("Fim recebeJson");
    }
}
