package com.generation.playGame.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "tb_categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nome;

    @OneToMany(mappedBy = "categoria") // Relacionamento um-para-muitos com Jogo
    private List<ProdutoJogo> jogos;
}
