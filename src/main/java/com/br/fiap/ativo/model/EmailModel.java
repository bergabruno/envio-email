package com.br.fiap.ativo.model;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "Email")
public class EmailModel {

    @Id
    private String id;
    private String ownerRef;
    private String emailFrom;
    private String emailTo;
    private String subject;
    private String text;
    private String sendDateEmail;
    private StatusEmail statusEmail;

}
