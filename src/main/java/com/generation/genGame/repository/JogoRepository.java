package com.generation.genGame.repository;

import com.generation.genGame.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JogoRepository extends JpaRepository<Jogo, Long> {

    // Método especial para encontrar jogos pelo nome (contendo parte do nome)

    List<Jogo> findByNomeContaining(String nome);
}
