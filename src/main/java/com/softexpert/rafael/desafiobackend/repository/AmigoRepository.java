package com.softexpert.rafael.desafiobackend.repository;

import com.softexpert.rafael.desafiobackend.model.Amigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmigoRepository extends JpaRepository<Amigo, Long> {

    List<Amigo> findByNomeAndIdTransacao(String nome, int idTransacao);

    List<Amigo> findByIdTransacao(int idTransacao);
}