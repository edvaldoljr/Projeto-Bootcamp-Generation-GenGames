package com.generation.playGame.repository;

import com.generation.playGame.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {


    // Método especial para encontrar jogador pelo CPF (deve ser único)
    Jogador findByCpf(String cpf);
}
