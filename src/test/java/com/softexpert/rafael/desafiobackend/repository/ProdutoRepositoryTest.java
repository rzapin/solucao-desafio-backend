package com.softexpert.rafael.desafiobackend.repository;


import com.softexpert.rafael.desafiobackend.model.Amigo;
import com.softexpert.rafael.desafiobackend.model.Produto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Sql("classpath:table_produto.sql")
public class ProdutoRepositoryTest {

    @Autowired
    ProdutoRepository produtoRepository;

    @Test
    void deveCadastrarProdutoERetornarnaConsulta(){
        Produto produto = new Produto();
        produto = produto.builder().nome("Teste").valor(10.0).amigo("Amigo").idTransacao(1).build();
        Produto produtoSaved = produtoRepository.save(produto);

        Optional<Produto> byId = produtoRepository.findById(produtoSaved.getId());

        assertEquals(produto.getNome(), byId.get().getNome());
        assertEquals(produto.getIdTransacao(), byId.get().getIdTransacao());
    }

    @Test
    void deveRetornarSomaDosProdutosDoAmigo(){
        Optional<Produto> produto1 = produtoRepository.findById(2L);
        Optional<Produto> produto2 = produtoRepository.findById(3L);

        if(produto1.isPresent()) {
            Double soma = produtoRepository.selectTotalAmigo(produto1.get().getAmigo(), produto1.get().getIdTransacao());

            assertEquals(produto1.get().getValor() + produto2.get().getValor(), soma);
        }
    }
}
