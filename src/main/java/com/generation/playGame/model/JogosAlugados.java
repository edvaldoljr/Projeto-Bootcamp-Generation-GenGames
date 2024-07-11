package com.generation.playGame.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "tb_jogos_alugados")
public class JogosAlugados {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "jogo_id")
    private ProdutoJogo jogo; // Jogo alugado

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador; // Jogador que alugou o jogo

    @Column(name = "data_aluguel")
    private LocalDate dataAluguel; // Data do aluguel

    public void setId(Long id) {

    }
}