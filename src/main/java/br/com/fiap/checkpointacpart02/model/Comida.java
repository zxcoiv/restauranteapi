package br.com.fiap.checkpointacpart02.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "comidas")
public class Comida {
    @Id
    private Long id;

    @Column(name = "nome_comida", length = 100, nullable = false)
    private String nome;

    @Column(nullable = false)
    private Double preco;

    @Column(nullable = false)
    private Integer qtd;

    private String descricao;
}
