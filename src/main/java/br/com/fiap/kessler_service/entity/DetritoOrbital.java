package br.com.fiap.kessler_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "detritos_orbitais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetritoOrbital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetrito;

    @Column(name = "tipo_detrito")
    private String tipoDetrito;

    @Column(name = "massa_kg")
    private Double massaKg;

    @Column(name = "altitude_atual_km", nullable = false)
    private Double altitudeAtualKm;

    @Column(name = "inclinacao_orbital_graus")
    private Double inclinacaoOrbitalGraus;

    @Column(name = "risco_conjuncao")
    private Double riscoConjuncao;

    @Column(name = "custo_remocao_estimado_brl", nullable = false)
    private Double custoRemocaoEstimadoBrl;

    @Column(name = "status_remocao")
    private String statusRemocao;

    @ManyToOne
    @JoinColumn(name = "id_missao")
    private Missao missaoOrigem;
}