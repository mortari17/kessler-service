package br.com.fiap.kessler_service.service;

import br.com.fiap.kessler_service.dto.TecnologiaRequestDto;
import br.com.fiap.kessler_service.dto.TecnologiaResponseDto;
import br.com.fiap.kessler_service.entity.Tecnologia;
import br.com.fiap.kessler_service.repository.TecnologiaRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TecnologiaService {

    private final TecnologiaRepository repository;
    private final ModelMapper modelMapper;

    private static final String ENTITY_NOT_FOUND_MSG = "Tecnologia não encontrada com id: %d";

    public List<TecnologiaResponseDto> findAll() {
        return repository.findAll().stream()
                .map(this::toResponseDto)
                .collect(Collectors.toList());
    }

    public TecnologiaResponseDto findById(Long id) {
        Tecnologia entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(ENTITY_NOT_FOUND_MSG, id)));
        return toResponseDto(entity);
    }

    public TecnologiaResponseDto create(TecnologiaRequestDto requestDto) {
        Tecnologia entity = modelMapper.map(requestDto, Tecnologia.class);
        entity = repository.save(entity);
        return toResponseDto(entity);
    }

    public TecnologiaResponseDto update(Long id, TecnologiaRequestDto requestDto) {
        Tecnologia entity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format(ENTITY_NOT_FOUND_MSG, id)));
        modelMapper.map(requestDto, entity);
        entity = repository.save(entity);
        return toResponseDto(entity);
    }

    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException(String.format(ENTITY_NOT_FOUND_MSG, id));
        }
        repository.deleteById(id);
    }

    private TecnologiaResponseDto toResponseDto(Tecnologia entity) {
        return modelMapper.map(entity, TecnologiaResponseDto.class);
    }
}