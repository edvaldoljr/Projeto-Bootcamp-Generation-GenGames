package com.generation.genGame.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_jogo")
public class Jogo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String nome;

    @Column(nullable = false, length = 500)
    private String descricao;

    @ManyToOne //Relacionamento um-para-muitos 1:N
    @JoinColumn(name = "categoria_id")
    private Categoria categoria; // propriedade adicionada

    @Column(name = "preco_venda", precision = 10, scale = 2)
    private BigDecimal precoVenda;

    @Column(name = "preco_aluguel", precision = 10, scale = 2)
    private BigDecimal precoaluguel;

    @Column(name = "disponivel_venda", nullable = false)
    private int dispoVenda;

    @Column(name = "disponivel_aluguel", nullable = false)
    private int dispoAluguel;

    @OneToMany(mappedBy = "jogo")
    private Set<JogosAlugados> jogosAlugados = new HashSet<>(); // Relacionamento de um jogo com vários aluguéis
}
