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

    private static final String TECNOLOGIA_NOT_FOUND_MSG = "Tecnologia não encontrada com id: %d";
    private static final String MISSAO_NOT_FOUND_MSG = "Missao not found with id: %d";

    @Transactional
    public MissaoResponseDto create(MissaoRequestDto requestDto) {
        Tecnologia tecnologia = tecnologiaRepository.findById(requestDto.getIdTecnologia())
                .orElseThrow(() -> new ResourceNotFoundException(String.format(TECNOLOGIA_NOT_FOUND_MSG, requestDto.getIdTecnologia())));
        Missao missao = modelMapper.map(requestDto, Missao.class);
        missao.setTecnologia(tecnologia);
        missao = missaoRepository.save(missao);
        return modelMapper.map(missao, MissaoResponseDto.class);
    }

    public MissaoResponseDto findById(Long id) {
        Missao missao = missaoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(String.format(MISSAO_NOT_FOUND_MSG, id)));
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
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(MISSAO_NOT_FOUND_MSG, id)));

        Tecnologia tecnologia = tecnologiaRepository.findById(requestDto.getIdTecnologia())
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format(TECNOLOGIA_NOT_FOUND_MSG, requestDto.getIdTecnologia())));

        missao.setNomeMissao(requestDto.getNomeMissao());
        missao.setAgenciaResponsavel(requestDto.getAgenciaResponsavel());
        missao.setPaisOrigem(requestDto.getPaisOrigem());
        missao.setAnoLancamento(requestDto.getAnoLancamento());
        missao.setStatusMissao(requestDto.getStatusMissao());
        missao.setTecnologia(tecnologia); // entidade gerenciada correta

        missao = missaoRepository.save(missao);
        return modelMapper.map(missao, MissaoResponseDto.class);
    }

    @Transactional
    public void delete(Long id) {
        if (!missaoRepository.existsById(id)) {
            throw new ResourceNotFoundException(String.format(MISSAO_NOT_FOUND_MSG, id));
        }
        missaoRepository.deleteById(id);
    }
}