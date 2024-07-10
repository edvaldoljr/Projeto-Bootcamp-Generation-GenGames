package com.generation.genGame.controller;

import com.generation.genGame.model.Categoria;
import com.generation.genGame.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaRepository categoriaRepository;

    // Criar uma nova categoria
    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        Categoria novaCategoria = categoriaRepository.save(categoria);
        return ResponseEntity.ok(novaCategoria);
    }

    // Buscar todas as categorias
    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return ResponseEntity.ok(categorias);
    }

    // Buscar uma categoria por ID
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscarCategoriaPorId(@PathVariable Long id) {
        Optional<Categoria> categoriaOpt = categoriaRepository.findById(id);
        return categoriaOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Deletar uma categoria
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCategoria(@PathVariable Long id) {
        if (!categoriaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        categoriaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

