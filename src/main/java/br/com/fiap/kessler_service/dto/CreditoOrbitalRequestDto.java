package br.com.fiap.kessler_service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditoOrbitalRequestDto {

    @NotNull(message = "valorBrl é obrigatório")
    private BigDecimal valorBrl;

    private String tipoComprador;

    @NotNull(message = "dataTransacao é obrigatório")
    private LocalDateTime dataTransacao;

    private String statusCredito;

    private Long idDetrito;
}