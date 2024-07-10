package com.generation.genGame.repository;

import com.generation.genGame.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    // Método especial para encontrar categorias pelo nome (contendo parte do nome)
    List<Categoria> findByNomeContaining(String nome);

    // Método especial para encontrar categorias que não possuem jogos associados
    List<Categoria> findByJogosIsEmpty();
}
