package com.generation.genGame.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name = "tb_jogador")
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome_jogador", nullable = false, length = 100)
    private String nome;

    @Column(length = 11)
    private String cpf;

    @Column(nullable = false)
    private String endereco;

    @OneToMany(mappedBy = "jogador")
    private Set<JogosAlugados> jogosAlugados = new HashSet<>(); // Relacionamento de um jogador com vários aluguéis de jogos

    public void setId(Long id) {
    }
}
