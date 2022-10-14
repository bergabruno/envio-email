package com.br.fiap.ativo.service;

import java.time.LocalDateTime;
import java.util.List;

import com.br.fiap.ativo.model.EmailModel;
import com.br.fiap.ativo.model.EmailModelDTO;
import com.br.fiap.ativo.model.StatusEmail;
import com.br.fiap.ativo.repository.EmailRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public interface EmailService {

    EmailModel sendEmail(EmailModel emailModel);

    List<EmailModelDTO> findAll();

    List<EmailModelDTO> findAllByDate(String date);
}
