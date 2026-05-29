package br.com.fiap.kessler_service.service;

import br.com.fiap.kessler_service.dto.DetritoOrbitalRequestDto;
import br.com.fiap.kessler_service.dto.DetritoOrbitalResponseDto;
import br.com.fiap.kessler_service.exception.ResourceNotFoundException;
import br.com.fiap.kessler_service.mapper.DetritoOrbitalMapper;
import br.com.fiap.kessler_service.model.DetritoOrbital;
import br.com.fiap.kessler_service.model.Missao;
import br.com.fiap.kessler_service.repository.DetritoOrbitalRepository;
import br.com.fiap.kessler_service.repository.MissaoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DetritoOrbitalService {

    @Autowired
    private DetritoOrbitalRepository detritoOrbitalRepository;

    private static final String DETRITO_NOT_FOUND_MSG = "Detrito orbital não encontrado com id: %d";
    private static final String MISSAO_NOT_FOUND_MSG = "Missao não encontrada com id: %d";

    @Autowired
    private MissaoRepository missaoRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<DetritoOrbitalResponseDto> findAll() {
        return detritoOrbitalRepository.findAll()
                .stream()
                .map(detrito -> modelMapper.map(detrito, DetritoOrbitalResponseDto.class))
                .collect(Collectors.toList());
    }

    public DetritoOrbitalResponseDto findById(Long id) {
        DetritoOrbital detrito = detritoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(DETRITO_NOT_FOUND_MSG, id)));
        return modelMapper.map(detrito, DetritoOrbitalResponseDto.class);
    }

    @Transactional
    public DetritoOrbitalResponseDto create(DetritoOrbitalRequestDto requestDto) {

        Missao missao = missaoRepository.findById(requestDto.getIdMissao())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(MISSAO_NOT_FOUND_MSG, requestDto.getIdMissao())));

        DetritoOrbital detrito = DetritoOrbitalMapper.fromDto(
                requestDto,
                missao
        );

        DetritoOrbital saved = detritoOrbitalRepository.save(detrito);

        return modelMapper.map(saved, DetritoOrbitalResponseDto.class);
    }

    @Transactional
    public DetritoOrbitalResponseDto update(Long id, DetritoOrbitalRequestDto requestDto) {
        DetritoOrbital detrito = detritoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(DETRITO_NOT_FOUND_MSG, id)));

        Missao missao = missaoRepository.findById(requestDto.getIdMissao())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(MISSAO_NOT_FOUND_MSG, requestDto.getIdMissao())));

        DetritoOrbitalMapper.updateFromDto(
        requestDto,
        detrito,
        missao
);

        DetritoOrbital updated = detritoOrbitalRepository.save(detrito);
        return modelMapper.map(updated, DetritoOrbitalResponseDto.class);
    }

    @Transactional
    public void delete(Long id) {
        DetritoOrbital detrito = detritoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(DETRITO_NOT_FOUND_MSG, id)));
        detritoOrbitalRepository.delete(detrito);
    }
}