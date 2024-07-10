package com.generation.genGame.controller;

import com.generation.genGame.model.Jogo;
import com.generation.genGame.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jogos")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    // Criar um jogo
    @PostMapping
    public ResponseEntity<Jogo> criarJogo(@RequestBody Jogo jogo) {
        Jogo novoJogo = jogoRepository.save(jogo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoJogo);
    }

    // Buscar todos os jogos
    @GetMapping
    public ResponseEntity<List<Jogo>> listarJogos() {
        List<Jogo> jogos = jogoRepository.findAll();
        return ResponseEntity.ok(jogos);
    }

    // Buscar jogos pelo nome (contendo parte do nome)
    @GetMapping("/search")
    public ResponseEntity<List<Jogo>> buscarJogosPorNome(@RequestParam String nome) {
        List<Jogo> jogos = jogoRepository.findByNomeContaining(nome);
        return ResponseEntity.ok(jogos);
    }

    // Buscar jogo por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogo> buscarJogoPorId(@PathVariable Long id) {
        Optional<Jogo> jogo = jogoRepository.findById(id);
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