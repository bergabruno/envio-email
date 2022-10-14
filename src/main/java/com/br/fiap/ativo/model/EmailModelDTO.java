package com.br.fiap.ativo.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EmailModelDTO {

    private String id;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private String sendDateEmail;
    private StatusEmail statusEmail;
}
