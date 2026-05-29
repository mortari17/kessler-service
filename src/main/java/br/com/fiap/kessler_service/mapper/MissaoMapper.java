package br.com.fiap.kessler_service.mapper;

import br.com.fiap.kessler_service.dto.MissaoRequestDto;
import br.com.fiap.kessler_service.entity.Tecnologia;
import br.com.fiap.kessler_service.entity.Missao;

public class MissaoMapper {
    public static Missao fromDto(
            MissaoRequestDto dto,
            Tecnologia tecnologia
    ) {
        Missao missao = new Missao();

        missao.setNomeMissao(dto.getNomeMissao());
        missao.setAgenciaResponsavel(dto.getAgenciaResponsavel());
        missao.setPaisOrigem(dto.getPaisOrigem());
        missao.setAnoLancamento(dto.getAnoLancamento());
        missao.setStatusMissao(dto.getStatusMissao());

        missao.setTecnologia(tecnologia);

        return missao;
    }

    public static void updateFromDto(
        MissaoRequestDto dto,
        Missao missao,
        Tecnologia tecnologia
    ) {
        missao.setNomeMissao(dto.getNomeMissao());
        missao.setAgenciaResponsavel(dto.getAgenciaResponsavel());
        missao.setPaisOrigem(dto.getPaisOrigem());
        missao.setAnoLancamento(dto.getAnoLancamento());
        missao.setStatusMissao(dto.getStatusMissao());

        missao.setTecnologia(tecnologia);
    }
}
