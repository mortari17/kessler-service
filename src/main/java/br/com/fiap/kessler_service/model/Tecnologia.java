package br.com.fiap.kessler_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tecnologias")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tecnologia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnologia")
    private Long idTecnologia;

    @Column(name = "nome_tecnologia", nullable = false)
    private String nomeTecnologia;

    @Column(nullable = false)
    private String categoria;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @Column(name = "tipo_propulsao")
    private String tipoPropulsao;

    @Column(name = "vida_util_anos")
    private Integer vidaUtilAnos;
}