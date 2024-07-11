package com.generation.playGame.controller;

import com.generation.playGame.model.ProdutoJogo;
import com.generation.playGame.repository.ProdutoJogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jogos")
public class ProdutoJogoController {

    @Autowired
    private ProdutoJogoRepository jogoRepository;

    // Criar um jogo
    @PostMapping
    public ResponseEntity<ProdutoJogo> criarJogo(@RequestBody ProdutoJogo jogo) {
        ProdutoJogo novoJogo = jogoRepository.save(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogo);
    }

    // Buscar todos os jogos
    @GetMapping
    public ResponseEntity<List<ProdutoJogo>> listarJogos() {
        List<ProdutoJogo> jogos = jogoRepository.findAll();
        return ResponseEntity.ok(jogos);
    }

    // Buscar jogos pelo nome (contendo parte do nome)
    @GetMapping("/search")
    public ResponseEntity<List<ProdutoJogo>> buscarJogosPorNome(@RequestParam String nome) {
        List<ProdutoJogo> jogos = jogoRepository.findByNomeContaining(nome);
        return ResponseEntity.ok(jogos);
    }

    // Buscar jogo por ID
    @GetMapping("/{id}")
    public ResponseEntity<ProdutoJogo> buscarJogoPorId(@PathVariable Long id) {
        Optional<ProdutoJogo> jogo = jogoRepository.findById(id);
        return jogo.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar jogo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogo(@PathVariable Long id) {
        if (!jogoRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}