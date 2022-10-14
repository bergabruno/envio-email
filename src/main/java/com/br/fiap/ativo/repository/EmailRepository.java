package com.br.fiap.ativo.repository;

import com.br.fiap.ativo.model.EmailModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepository extends CrudRepository<EmailModel, String> {

    Optional<List<EmailModel>> findAllBySendDateEmail(String date);

}
