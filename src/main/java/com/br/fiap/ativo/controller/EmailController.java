package com.br.fiap.ativo.controller;

import com.br.fiap.ativo.model.EmailModel;
import com.br.fiap.ativo.model.EmailModelDTO;
import com.br.fiap.ativo.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email")
    public ResponseEntity<EmailModel> sendEmail(@RequestBody EmailModel model){
        emailService.sendEmail(model);
        return ResponseEntity.ok(model);
    }

    @GetMapping
    public ResponseEntity<List<EmailModelDTO>> findAll(){

       List<EmailModelDTO> lista =  emailService.findAll();

        return ResponseEntity.ok(lista);

    }
}
