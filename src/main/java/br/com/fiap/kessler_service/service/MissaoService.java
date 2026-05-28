package br.com.fiap.kessler_service.service;

import br.com.fiap.kessler_service.dto.MissaoRequestDto;
import br.com.fiap.kessler_service.dto.MissaoResponseDto;
import br.com.fiap.kessler_service.exception.ResourceNotFoundException;
import br.com.fiap.kessler_service.entity.Missao;
import br.com.fiap.kessler_service.entity.Tecnologia;
import br.com.fiap.kessler_service.repository.MissaoRepository;
import br.com.fiap.kessler_service.repository.TecnologiaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MissaoService {

    private final MissaoRepository missaoRepository;
    private final TecnologiaRepository tecnologiaRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public MissaoResponseDto create(MissaoRequestDto requestDto) {
        Tecnologia tecnologia = tecnologiaRepository.findById(requestDto.getIdTecnologia())
                .orElseThrow(() -> new ResourceNotFoundException("Tecnologia not found with id: " + requestDto.getIdTecnologia()));
        Missao missao = modelMapper.map(requestDto, Missao.class);
        missao.setTecnologia(tecnologia);
        missao = missaoRepository.save(missao);
        return modelMapper.map(missao, MissaoResponseDto.class);
    }

    public MissaoResponseDto findById(Long id) {
        Missao missao = missaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Missao not found with id: " + id));
        return modelMapper.map(missao, MissaoResponseDto.class);
    }

    public List<MissaoResponseDto> findAll() {
        return missaoRepository.findAll().stream()
                .map(missao -> modelMapper.map(missao, MissaoResponseDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public MissaoResponseDto update(Long id, MissaoRequestDto requestDto) {
        Missao missao = missaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Missao not found with id: " + id));
        Tecnologia tecnologia = tecnologiaRepository.findById(requestDto.getIdTecnologia())
                .orElseThrow(() -> new ResourceNotFoundException("Tecnologia not found with id: " + requestDto.getIdTecnologia()));
        modelMapper.map(requestDto, missao);
        missao.setTecnologia(tecnologia);
        missao = missaoRepository.save(missao);
        return modelMapper.map(missao, MissaoResponseDto.class);
    }

    @Transactional
    public void delete(Long id) {
        if (!missaoRepository.existsById(id)) {
            throw new ResourceNotFoundException("Missao not found with id: " + id);
        }
        missaoRepository.deleteById(id);
    }
}