package com.softexpert.rafael.desafiobackend.service;

import com.softexpert.rafael.desafiobackend.model.Amigo;
import com.softexpert.rafael.desafiobackend.repository.AmigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.List;

@Service
public class AmigoService {

    @Autowired
    AmigoRepository amigoRepository;

    public Amigo addAmigo(String nome, Double valorTotal, int idTransacao) {
        try {

            DecimalFormatSymbols symbols = new DecimalFormatSymbols();

            symbols.setDecimalSeparator('.');

            DecimalFormat df = new DecimalFormat("0.00", symbols);
            ;

            Amigo newAmigo = amigoRepository.save(new Amigo(nome, Double.valueOf(df.format(valorTotal)), idTransacao));

            return newAmigo;
        } catch (Exception e) {
            throw e;
        }
    }

    public List<Amigo> selecionaAmigos(int idTransacao) {
        return amigoRepository.findByIdTransacao(idTransacao);
    }


}
