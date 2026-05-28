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
public class MissaoRequestDto {

    @NotBlank(message = "Nome da missão é obrigatório")
    private String nomeMissao;

    @NotBlank(message = "Agência responsável é obrigatória")
    private String agenciaResponsavel;

    private String paisOrigem;

    private Integer anoLancamento;

    private String statusMissao;

    private Long idTecnologia;
}