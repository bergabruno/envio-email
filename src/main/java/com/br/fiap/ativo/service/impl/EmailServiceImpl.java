package com.br.fiap.ativo.service.impl;

import com.br.fiap.ativo.model.EmailModel;
import com.br.fiap.ativo.model.EmailModelDTO;
import com.br.fiap.ativo.model.StatusEmail;
import com.br.fiap.ativo.repository.EmailRepository;
import com.br.fiap.ativo.service.EmailService;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Log4j2
public class EmailServiceImpl implements EmailService {

    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private MailSender emailSender;

    public EmailModel sendEmail(EmailModel emailModel) {

        log.info("Enviando email");
        String data = LocalDateTime.now().toString().substring(0, 10);
        emailModel.setSendDateEmail(data);
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(emailModel.getEmailFrom());
            message.setTo(emailModel.getEmailTo());
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());

            emailSender.send(message);
            emailModel.setStatusEmail(StatusEmail.SEND);

            log.info("Email enviado com sucesso");
        }catch (Exception e){
            log.info("Nao foi possivel enviar email!");
            emailModel.setStatusEmail(StatusEmail.ERROR);
        }finally {
            return emailRepository.save(emailModel);
        }

    }

    @Override
    public List<EmailModelDTO> findAll() {
        ModelMapper modelMapper = new ModelMapper();

        List<EmailModel> lista = (List<EmailModel>) emailRepository.findAll();

        List<EmailModelDTO> listaDTO = lista
                .stream()
                .map(emailModel -> modelMapper.map(emailModel, EmailModelDTO.class))
                .collect(Collectors.toList());

        return listaDTO;
    }

    @Override
    public List<EmailModelDTO> findAllByDate(String date) {
        ModelMapper modelMapper = new ModelMapper();

        List<EmailModel> listagem = new ArrayList<>();
        Optional<List<EmailModel>> lista =  emailRepository.findAllBySendDateEmail(date);

        if(lista.isPresent())
            listagem = lista.get();
        else
            throw new RuntimeException("nao existe nenhum email com essa data");

        List<EmailModelDTO> listaDTO = listagem
                .stream()
                .map(emailModel -> modelMapper.map(emailModel, EmailModelDTO.class))
                .collect(Collectors.toList());

        return listaDTO;
    }
}
