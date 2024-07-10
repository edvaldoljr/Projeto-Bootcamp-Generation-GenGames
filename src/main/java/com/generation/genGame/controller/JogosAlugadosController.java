package com.generation.genGame.controller;

import com.generation.genGame.model.JogosAlugados;
import com.generation.genGame.repository.JogosAlugadosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jogos-alugados")
public class JogosAlugadosController {

    @Autowired
    private JogosAlugadosRepository jogosAlugadosRepository;

    // Criar um novo registro de jogo alugado
    @PostMapping
    public ResponseEntity<JogosAlugados> criarJogoAlugado(@RequestBody JogosAlugados jogosAlugados) {
        JogosAlugados novoJogoAlugado = jogosAlugadosRepository.save(jogosAlugados);
        return ResponseEntity.ok(novoJogoAlugado);
    }

    // Buscar todos os registros de jogos alugados
    @GetMapping
    public ResponseEntity<List<JogosAlugados>> listarJogosAlugados() {
        List<JogosAlugados> jogosAlugados = jogosAlugadosRepository.findAll();
        return ResponseEntity.ok(jogosAlugados);
    }

    // Buscar um registro de jogo alugado por ID
    @GetMapping("/{id}")
    public ResponseEntity<JogosAlugados> buscarJogoAlugadoPorId(@PathVariable Long id) {
        Optional<JogosAlugados> jogoAlugadoOpt = jogosAlugadosRepository.findById(id);
        return jogoAlugadoOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Atualizar um registro de jogo alugado
    @PutMapping("/{id}")
    public ResponseEntity<JogosAlugados> atualizarJogoAlugado(@PathVariable Long id, @RequestBody JogosAlugados jogoAlugadoAtualizado) {
        if (!jogosAlugadosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogoAlugadoAtualizado.setId(id);
        JogosAlugados jogoAlugado = jogosAlugadosRepository.save(jogoAlugadoAtualizado);
        return ResponseEntity.ok(jogoAlugado);
    }

    // Deletar um registro de jogo alugado
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarJogoAlugado(@PathVariable Long id) {
        if (!jogosAlugadosRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        jogosAlugadosRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
