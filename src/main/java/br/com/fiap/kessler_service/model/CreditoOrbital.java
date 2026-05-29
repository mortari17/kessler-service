package br.com.fiap.kessler_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "creditos_orbitais")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditoOrbital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCredito;

    @Column(nullable = false)
    private Double valorBrl;

    @Column(name = "tipo_comprador")
    private String tipoComprador;

    @Column(nullable = false)
    private LocalDateTime dataTransacao;

    @Column(name = "status_credito")
    private String statusCredito;

    @ManyToOne
    @JoinColumn(name = "id_detrito")
    private DetritoOrbital detrito;
}