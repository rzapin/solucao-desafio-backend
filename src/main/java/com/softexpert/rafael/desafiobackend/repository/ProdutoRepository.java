package com.softexpert.rafael.desafiobackend.repository;

import com.softexpert.rafael.desafiobackend.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query(value = "SELECT SUM(p.valor) FROM Produto p where p.idTransacao = :idTransacao")
    Double selectTotalTransacao(@Param("idTransacao") int idTransacao);

    @Query(value = "SELECT SUM(p.valor) FROM Produto p where p.amigo = :amigo and p.idTransacao = :idTransacao")
    Double selectTotalAmigo(@Param("amigo") String amigo, @Param("idTransacao") int idTransacao);

    @Query(value = "SELECT DISTINCT p.amigo FROM Produto p where p.idTransacao = :idTransacao")
    List<String> selectAmigos(@Param("idTransacao") int idTransacao);
}
