package br.com.fiap.kessler_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TecnologiaResponseDto {

    private Long idTecnologia;
    private String nomeTecnologia;
    private String categoria;
    private String descricao;
    private String tipoPropulsao;
    private Integer vidaUtilAnos;
}