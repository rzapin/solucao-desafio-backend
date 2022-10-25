package com.softexpert.rafael.desafiobackend.service;

import com.softexpert.rafael.desafiobackend.model.Produto;
import com.softexpert.rafael.desafiobackend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto addProduto(Produto produto) {
        try {
            Produto newProduto;

            newProduto = produtoRepository.save(new Produto(produto.getNome(), produto.getAmigo(), produto.getValor(), produto.getIdTransacao()));

            return newProduto;
        } catch (Exception e) {
            throw e;
        }
    }

    public Double calculaTotalTransacao(int idTransacao) {
        try {
            return produtoRepository.selectTotalTransacao(idTransacao);
        } catch (Exception e) {
            throw e;
        }
    }

    public Double calculaTotalAmigo(String amigo, int idTransacao) {
        try {
            return produtoRepository.selectTotalAmigo(amigo, idTransacao);
        } catch (Exception e) {
            throw e;
        }
    }

    public Double calculaPercentualAmigo(String amigo, int idTransacao) {
        try {
            Double totalGeral = calculaTotalTransacao(idTransacao);
            Double totalAmigo = calculaTotalAmigo(amigo, idTransacao);

            return totalAmigo / totalGeral;

        } catch (Exception e) {
            throw e;
        }
    }

    public List<String> selecionaAmigos(int idTransacao) {
        try {
            return produtoRepository.selectAmigos(idTransacao);
        } catch (Exception e) {
            throw e;
        }
    }
}
