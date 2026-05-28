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
    private String nome;

    private String descricao;
}