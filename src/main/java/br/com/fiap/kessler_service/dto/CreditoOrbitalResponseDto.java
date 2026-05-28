package br.com.fiap.kessler_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditoOrbitalResponseDto {
    private Long idCredito;
    private Double valorBrl;
    private String tipoComprador;
    private LocalDateTime dataTransacao;
    private String statusCredito;
    private Long idDetrito;
}