package com.softexpert.rafael.desafiobackend.controller;

import com.softexpert.rafael.desafiobackend.model.Amigo;
import com.softexpert.rafael.desafiobackend.service.AmigoService;
import com.softexpert.rafael.desafiobackend.service.DescontoDespesaService;
import com.softexpert.rafael.desafiobackend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AmigoController {

    @Autowired
    AmigoService amigoService;

    @Autowired
    ProdutoService produtoService;

    @Autowired
    DescontoDespesaService descontoDespesaService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PutMapping("/totais/{idTransacao}")
    public ResponseEntity<List<Amigo>> calculaTotais(@PathVariable int idTransacao) {
        List<String> amigos = produtoService.selecionaAmigos(idTransacao);

        Double totalTransacao = produtoService.calculaTotalTransacao(idTransacao);

        Double totalDescontosEDespesas = descontoDespesaService.calculaTotalDescontosEDespesas(totalTransacao, idTransacao);

        Double totalGeral = totalTransacao + totalDescontosEDespesas;

        for (String amigo : amigos) {
            Double percentual = produtoService.calculaPercentualAmigo(amigo, idTransacao);
            Double totalPagar = Double.valueOf(totalGeral * percentual);
            amigoService.addAmigo(amigo, totalPagar, idTransacao);
        }

        return new ResponseEntity<>(amigoService.selecionaAmigos(idTransacao), HttpStatus.OK);
    }

    @GetMapping("/amigos/{idTransacao}")
    public ResponseEntity<List<Amigo>> selecionaAmigos(@PathVariable int idTransacao) {
        return new ResponseEntity<>(amigoService.selecionaAmigos(idTransacao), HttpStatus.OK);
    }

}