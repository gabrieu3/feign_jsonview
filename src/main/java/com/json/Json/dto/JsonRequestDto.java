package com.json.Json.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.json.Json.view.JsonViews;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Data
public class JsonRequestDto {

    @JsonView(JsonViews.Standin.class)
    private String nome;

    private String idade;

    @JsonView({JsonViews.Conta.class, JsonViews.Standin.class})
    private String tamanho;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate nascimento = LocalDate.from(LocalDateTime.now().atZone(ZoneId.of("America/Sao_Paulo")));

}
