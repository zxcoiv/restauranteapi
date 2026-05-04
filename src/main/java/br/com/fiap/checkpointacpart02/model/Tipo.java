package br.com.fiap.checkpointacpart02.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tipos")
public class Tipo {
    @Id
    private Long id;
    @Column(name = "tipo_comida", length = 100,
            columnDefinition = "char(100)", nullable = false)
    private String tipo;
}
