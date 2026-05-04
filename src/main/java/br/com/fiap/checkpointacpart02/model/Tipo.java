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

    @Column(nullable = false)
    private String paisDeOrigem;

    private String pontoDaCarne;

    @Column(nullable = false)
    private Boolean contemAlergenicos;

    @Column(nullable = false)
    private String temperaturaDoPrato;
}
