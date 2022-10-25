package com.softexpert.rafael.desafiobackend.repository;

import com.softexpert.rafael.desafiobackend.model.DescontoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DescontoDespesaRepository extends JpaRepository<DescontoDespesa, Long> {

    List<DescontoDespesa> findByIdTransacao(int idTransacao);

    @Query(value = "SELECT SUM(d.valor) FROM DescontoDespesa d where d.idTransacao = :idTransacao")
    Double selectTotal(@Param("idTransacao") int idTransacao);
}
