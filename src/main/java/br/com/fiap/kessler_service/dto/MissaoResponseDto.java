package br.com.fiap.kessler_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MissaoResponseDto {
    private Long idMissao;
    private String nomeMissao;
    private String agenciaResponsavel;
    private String paisOrigem;
    private Integer anoLancamento;
    private String statusMissao;
    private TecnologiaResponseDto tecnologia;
}