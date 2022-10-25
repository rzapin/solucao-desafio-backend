package com.softexpert.rafael.desafiobackend.controller;

import com.softexpert.rafael.desafiobackend.model.Produto;
import com.softexpert.rafael.desafiobackend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProdutoController {

    @Autowired
    ProdutoService produtoService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/produtos")
    public ResponseEntity<Produto> createProduto(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.addProduto(produto), HttpStatus.CREATED);
    }
}
