package com.softexpert.rafael.desafiobackend.repository;

import com.softexpert.rafael.desafiobackend.model.Amigo;
import com.softexpert.rafael.desafiobackend.model.DescontoDespesa;
import com.softexpert.rafael.desafiobackend.model.type.TipoDescontoDespesaEnum;
import com.softexpert.rafael.desafiobackend.model.type.TipoValorEnum;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql("classpath:table_desconto_despesa.sql")
public class DescontoDespesaRepositoryTest {

    @Autowired
    DescontoDespesaRepository descontoDespesaRepository;

    @Test
    void deveCadastrarDescontoDespesaERetornarnaConsulta(){
        DescontoDespesa descontoDespesa = new DescontoDespesa();
        descontoDespesa = descontoDespesa.builder().id(3L).descricao("Teste").valor(10.0).tipoValor(TipoValorEnum.moeda).tipoDescontoDespesa(TipoDescontoDespesaEnum.despesa).idTransacao(1).build();
        DescontoDespesa descontoDespesaSaved = descontoDespesaRepository.save(descontoDespesa);

        List<DescontoDespesa> byIdTransacao = descontoDespesaRepository.findByIdTransacao(descontoDespesaSaved.getIdTransacao());

        assertEquals(descontoDespesa.getDescricao(), byIdTransacao.get(0).getDescricao());
    }

    @Test
    void deveRetornarSomaDosDescontosEDespesasDeTodosOsAmigos(){

        Optional<DescontoDespesa> descontoDespesa1 = descontoDespesaRepository.findById(1L);
        Optional<DescontoDespesa> descontoDespesa2 = descontoDespesaRepository.findById(2L);

        if(descontoDespesa1.isPresent()) {
            Double soma = descontoDespesaRepository.selectTotal(descontoDespesa1.get().getIdTransacao());

            assertEquals(descontoDespesa1.get().getValor() + descontoDespesa2.get().getValor(), soma);
        }
    }
}
