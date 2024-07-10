package com.generation.genGame.repository;

import com.generation.genGame.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {


    // Método especial para encontrar jogador pelo CPF (deve ser único)
    Jogador findByCpf(String cpf);
}
