package br.com.fiap.kessler_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetritoOrbitalRequestDto {

    private String tipoDetrito;
    private Double massaKg;

    @NotNull
    private Double altitudeAtualKm;

    private Double inclinacaoOrbitalGraus;
    private Double riscoConjuncao;

    @NotNull
    private Double custoRemocaoEstimadoBrl;

    private String statusRemocao;
    private Long idMissao;
}