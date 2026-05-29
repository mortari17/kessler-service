package br.com.fiap.kessler_service.mapper;

import br.com.fiap.kessler_service.dto.DetritoOrbitalRequestDto;
import br.com.fiap.kessler_service.entity.DetritoOrbital;
import br.com.fiap.kessler_service.entity.Missao;

public class DetritoOrbitalMapper {
    public static DetritoOrbital fromDto(
            DetritoOrbitalRequestDto dto,
            Missao missao
    ) {

        DetritoOrbital detrito = new DetritoOrbital();

        detrito.setTipoDetrito(dto.getTipoDetrito());
        detrito.setMassaKg(dto.getMassaKg());
        detrito.setAltitudeAtualKm(dto.getAltitudeAtualKm());
        detrito.setInclinacaoOrbitalGraus(dto.getInclinacaoOrbitalGraus());
        detrito.setRiscoConjuncao(dto.getRiscoConjuncao());
        detrito.setCustoRemocaoEstimadoBrl(dto.getCustoRemocaoEstimadoBrl());
        detrito.setStatusRemocao(dto.getStatusRemocao());

        detrito.setMissaoOrigem(missao);

        return detrito;
    }

    public static void updateFromDto(
            DetritoOrbitalRequestDto dto,
            DetritoOrbital detrito,
            Missao missao
    ) {

        detrito.setTipoDetrito(dto.getTipoDetrito());
        detrito.setMassaKg(dto.getMassaKg());
        detrito.setAltitudeAtualKm(dto.getAltitudeAtualKm());
        detrito.setInclinacaoOrbitalGraus(dto.getInclinacaoOrbitalGraus());
        detrito.setRiscoConjuncao(dto.getRiscoConjuncao());
        detrito.setCustoRemocaoEstimadoBrl(dto.getCustoRemocaoEstimadoBrl());
        detrito.setStatusRemocao(dto.getStatusRemocao());

        detrito.setMissaoOrigem(missao);
    }
}
