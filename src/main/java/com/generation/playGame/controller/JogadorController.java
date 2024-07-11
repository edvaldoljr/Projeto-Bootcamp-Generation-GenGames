package com.generation.playGame.controller;


import com.generation.playGame.model.Jogador;
import com.generation.playGame.repository.JogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jogadores")
public class JogadorController {

    @Autowired
    private JogadorRepository jogadorRepository;

    // Criar um novo jogador
    @PostMapping
    public ResponseEntity<Jogador> criarJogador(@RequestBody Jogador jogador) {
        Jogador novoJogador = jogadorRepository.save(jogador);
        return ResponseEntity.ok(novoJogador);
    }

    // Buscar todos os jogadores
    @GetMapping
    public ResponseEntity<List<Jogador>> listarJogadores() {
        List<Jogador> jogadores = jogadorRepository.findAll();
        return ResponseEntity.ok(jogadores);
    }

    // Buscar um jogador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Jogador> buscarJogadorPorId(@PathVariable Long id) {
        Optional<Jogador> jogadorOpt = jogadorRepository.findById(id);
        return jogadorOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um jogador
    @PutMapping("/{id}")
    public ResponseEntity<Jogador> atualizarJogador(@PathVariable Long id, @RequestBody Jogador jogadorAtualizado) {
        if (!jogadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogadorAtualizado.setId(id);
        Jogador jogador = jogadorRepository.save(jogadorAtualizado);
        return ResponseEntity.ok(jogador);
    }

    // Buscar um jogador por CPF
    @GetMapping("/cpf/{cpf}")
    public ResponseEntity<Jogador> buscarJogadorPorCpf(@PathVariable String cpf) {
        Jogador jogador = jogadorRepository.findByCpf(cpf);
        return jogador != null ? ResponseEntity.ok(jogador) : ResponseEntity.notFound().build();
    }

    // Deletar um jogador
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogador(@PathVariable Long id) {
        if (!jogadorRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogadorRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
