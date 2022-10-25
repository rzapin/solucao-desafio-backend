package com.softexpert.rafael.desafiobackend.repository;

import com.softexpert.rafael.desafiobackend.model.Amigo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@Sql("classpath:table_amigo.sql")
public class AmigoRepositoryTest {

    @Autowired
    AmigoRepository amigoRepository;

    @Test
    void deveCadastrarAmigoERetornarnaConsulta(){
        Amigo amigo = new Amigo();
        amigo = amigo.builder().nome("Teste").valorTotal(10.0).idTransacao(1).build();
        Amigo amigoSaved = amigoRepository.save(amigo);

        List<Amigo> byNomeEId = amigoRepository.findByNomeAndIdTransacao(amigoSaved.getNome(), amigoSaved.getIdTransacao());

        assertEquals(amigo.getNome(), byNomeEId.get(0).getNome());
        assertEquals(amigo.getIdTransacao(), byNomeEId.get(0).getIdTransacao());
    }
}
