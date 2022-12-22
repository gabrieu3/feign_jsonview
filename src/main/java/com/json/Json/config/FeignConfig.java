package com.json.Json.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.json.Json.view.JsonViews;
import feign.Util;
import feign.codec.Encoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Encoder feignFormEncoder(ObjectFactory<HttpMessageConverters> converters) {
        return (object, bodyType, template) -> {
            try {
                template.body(new ObjectMapper().writerWithView(JsonViews.Conta.class).writeValueAsString(object));
            } catch(JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        };
    }
}
