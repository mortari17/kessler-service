package br.com.fiap.kessler_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DetritoOrbitalResponseDto {
    private Long idDetrito;
    private String tipoDetrito;
    private Double massaKg;
    private Double altitudeAtualKm;
    private Double inclinacaoOrbitalGraus;
    private String riscoConjuncao;
    private Double custoRemocaoEstimadoBrl;
    private String statusRemocao;
    private Long idMissao;
}