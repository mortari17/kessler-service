package br.com.fiap.kessler_service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnologiaRequestDto {

    @NotBlank(message = "Nome é obrigatório")
    private String nomeTecnologia;

    @NotBlank(message = "Categoria é obrigatória")
    private String categoria;

    private String descricao;

    private String tipoPropulsao;

    private Integer vidaUtilAnos;
}