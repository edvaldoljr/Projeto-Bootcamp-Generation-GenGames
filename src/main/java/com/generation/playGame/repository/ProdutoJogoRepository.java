package com.generation.playGame.repository;

import com.generation.playGame.model.ProdutoJogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoJogoRepository extends JpaRepository<ProdutoJogo, Long> {

    // Método especial para encontrar jogos pelo nome (contendo parte do nome)

    List<ProdutoJogo> findByNomeContaining(String nome);
}
