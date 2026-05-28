package br.com.fiap.kessler_service.service;

import br.com.fiap.kessler_service.dto.CreditoOrbitalRequestDto;
import br.com.fiap.kessler_service.dto.CreditoOrbitalResponseDto;
import br.com.fiap.kessler_service.entity.CreditoOrbital;
import br.com.fiap.kessler_service.entity.DetritoOrbital;
import br.com.fiap.kessler_service.exception.ResourceNotFoundException;
import br.com.fiap.kessler_service.repository.CreditoOrbitalRepository;
import br.com.fiap.kessler_service.repository.DetritoOrbitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CreditoOrbitalService {

    @Autowired
    private CreditoOrbitalRepository creditoOrbitalRepository;

    @Autowired
    private DetritoOrbitalRepository detritoOrbitalRepository;

    @Autowired
    private ModelMapper modelMapper;

    private static final String CREDITO_NOT_FOUND_MSG = "Crédito orbital não encontrado com id: %d";
    private static final String DETRITO_NOT_FOUND_MSG = "Detrito orbital não encontrado com id: %d";

    @Transactional
    public CreditoOrbitalResponseDto create(CreditoOrbitalRequestDto requestDto) {

        DetritoOrbital detrito = detritoOrbitalRepository.findById(requestDto.getIdDetrito())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(DETRITO_NOT_FOUND_MSG, requestDto.getIdDetrito())));

        CreditoOrbital credito = new CreditoOrbital();

        credito.setValorBrl(requestDto.getValorBrl());
        credito.setTipoComprador(requestDto.getTipoComprador());
        credito.setDataTransacao(requestDto.getDataTransacao());
        credito.setStatusCredito(requestDto.getStatusCredito());

        credito.setDetrito(detrito);

        CreditoOrbital savedCredito = creditoOrbitalRepository.save(credito);

        return modelMapper.map(savedCredito, CreditoOrbitalResponseDto.class);
    }

    public CreditoOrbitalResponseDto findById(Long id) {
        CreditoOrbital credito = creditoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(CREDITO_NOT_FOUND_MSG, id)));
        return modelMapper.map(credito, CreditoOrbitalResponseDto.class);
    }

    public List<CreditoOrbitalResponseDto> findAll() {
        List<CreditoOrbital> creditos = creditoOrbitalRepository.findAll();
        return creditos.stream()
                .map(credito -> modelMapper.map(credito, CreditoOrbitalResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public CreditoOrbitalResponseDto update(Long id, CreditoOrbitalRequestDto requestDto) {

        CreditoOrbital credito = creditoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(CREDITO_NOT_FOUND_MSG, id)));

        DetritoOrbital detrito = detritoOrbitalRepository.findById(requestDto.getIdDetrito())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(DETRITO_NOT_FOUND_MSG, requestDto.getIdDetrito())));

        credito.setValorBrl(requestDto.getValorBrl());
        credito.setTipoComprador(requestDto.getTipoComprador());
        credito.setDataTransacao(requestDto.getDataTransacao());
        credito.setStatusCredito(requestDto.getStatusCredito());
        credito.setDetrito(detrito);

        CreditoOrbital updated = creditoOrbitalRepository.save(credito);

        return modelMapper.map(updated, CreditoOrbitalResponseDto.class);
    }

    public void delete(Long id) {
        CreditoOrbital credito = creditoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(CREDITO_NOT_FOUND_MSG, id)));
        creditoOrbitalRepository.delete(credito);
    }
}