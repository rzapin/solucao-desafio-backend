package com.softexpert.rafael.desafiobackend.controller;

import com.softexpert.rafael.desafiobackend.model.DescontoDespesa;
import com.softexpert.rafael.desafiobackend.service.DescontoDespesaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DescontoDespesaController {

    @Autowired
    DescontoDespesaService descontoDespesaService;

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/descontosDespesas")
    public ResponseEntity<DescontoDespesa> createDescontoDespesa(@RequestBody DescontoDespesa descontoDespesa) {
        return new ResponseEntity<DescontoDespesa>(descontoDespesaService.addDescontoDespesa(descontoDespesa), HttpStatus.CREATED);
    }
}