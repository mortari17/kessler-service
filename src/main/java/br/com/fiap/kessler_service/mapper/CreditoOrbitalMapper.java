package br.com.fiap.kessler_service.mapper;

import br.com.fiap.kessler_service.dto.CreditoOrbitalRequestDto;
import br.com.fiap.kessler_service.model.CreditoOrbital;
import br.com.fiap.kessler_service.model.DetritoOrbital;

public class CreditoOrbitalMapper {
    public static CreditoOrbital fromDto(
            CreditoOrbitalRequestDto dto,
            DetritoOrbital detrito
    ) {

        CreditoOrbital credito = new CreditoOrbital();

        credito.setValorBrl(dto.getValorBrl());
        credito.setTipoComprador(dto.getTipoComprador());
        credito.setDataTransacao(dto.getDataTransacao());
        credito.setStatusCredito(dto.getStatusCredito());

        credito.setDetrito(detrito);

        return credito;
    }

    public static void updateFromDto(
            CreditoOrbitalRequestDto dto,
            CreditoOrbital credito,
            DetritoOrbital detrito
    ) {

        credito.setValorBrl(dto.getValorBrl());
        credito.setTipoComprador(dto.getTipoComprador());
        credito.setDataTransacao(dto.getDataTransacao());
        credito.setStatusCredito(dto.getStatusCredito());

        credito.setDetrito(detrito);
    }
}
