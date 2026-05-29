package br.com.fiap.kessler_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "missoes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Missao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_missao")
    private Long idMissao;

    @Column(name = "nome_missao", nullable = false)
    private String nomeMissao;

    @Column(name = "agencia_responsavel", nullable = false)
    private String agenciaResponsavel;

    @Column(name = "pais_origem")
    private String paisOrigem;

    @Column(name = "ano_lancamento")
    private Integer anoLancamento;

    @Column(name = "status_missao")
    private String statusMissao;

    @ManyToOne
    @JoinColumn(name = "id_tecnologia")
    private Tecnologia tecnologia;
}