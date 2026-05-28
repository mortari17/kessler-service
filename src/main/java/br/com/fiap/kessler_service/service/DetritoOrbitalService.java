package br.com.fiap.kessler_service.service;

import br.com.fiap.kessler_service.dto.DetritoOrbitalRequestDto;
import br.com.fiap.kessler_service.dto.DetritoOrbitalResponseDto;
import br.com.fiap.kessler_service.entity.DetritoOrbital;
import br.com.fiap.kessler_service.entity.Missao;
import br.com.fiap.kessler_service.exception.ResourceNotFoundException;
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
                .orElseThrow(() -> new ResourceNotFoundException("DetritoOrbital not found with id: " + id));
        return modelMapper.map(detrito, DetritoOrbitalResponseDto.class);
    }

    @Transactional
    public DetritoOrbitalResponseDto create(DetritoOrbitalRequestDto requestDto) {
        DetritoOrbital detrito = modelMapper.map(requestDto, DetritoOrbital.class);
        Missao missao = missaoRepository.findById(requestDto.getIdMissao())
                .orElseThrow(() -> new ResourceNotFoundException("Missao not found with id: " + requestDto.getIdMissao()));
        detrito.setMissaoOrigem(missao);
        DetritoOrbital saved = detritoOrbitalRepository.save(detrito);
        return modelMapper.map(saved, DetritoOrbitalResponseDto.class);
    }

    @Transactional
    public DetritoOrbitalResponseDto update(Long id, DetritoOrbitalRequestDto requestDto) {
        DetritoOrbital detrito = detritoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetritoOrbital not found with id: " + id));
        modelMapper.map(requestDto, detrito);
        Missao missao = missaoRepository.findById(requestDto.getIdMissao())
                .orElseThrow(() -> new ResourceNotFoundException("Missao not found with id: " + requestDto.getIdMissao()));
        detrito.setMissaoOrigem(missao);
        DetritoOrbital updated = detritoOrbitalRepository.save(detrito);
        return modelMapper.map(updated, DetritoOrbitalResponseDto.class);
    }

    @Transactional
    public void delete(Long id) {
        DetritoOrbital detrito = detritoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("DetritoOrbital not found with id: " + id));
        detritoOrbitalRepository.delete(detrito);
    }
}