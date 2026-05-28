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

    public CreditoOrbitalResponseDto create(CreditoOrbitalRequestDto requestDto) {
        DetritoOrbital detrito = detritoOrbitalRepository.findById(requestDto.getIdDetrito())
                .orElseThrow(() -> new ResourceNotFoundException("DetritoOrbital not found with id: " + requestDto.getIdDetrito()));

        CreditoOrbital credito = modelMapper.map(requestDto, CreditoOrbital.class);
        credito.setDetrito(detrito);

        CreditoOrbital savedCredito = creditoOrbitalRepository.save(credito);
        return modelMapper.map(savedCredito, CreditoOrbitalResponseDto.class);
    }

    public CreditoOrbitalResponseDto findById(Long id) {
        CreditoOrbital credito = creditoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CreditoOrbital not found with id: " + id));
        return modelMapper.map(credito, CreditoOrbitalResponseDto.class);
    }

    public List<CreditoOrbitalResponseDto> findAll() {
        List<CreditoOrbital> creditos = creditoOrbitalRepository.findAll();
        return creditos.stream()
                .map(credito -> modelMapper.map(credito, CreditoOrbitalResponseDto.class))
                .collect(Collectors.toList());
    }

    public CreditoOrbitalResponseDto update(Long id, CreditoOrbitalRequestDto requestDto) {
        CreditoOrbital existingCredito = creditoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CreditoOrbital not found with id: " + id));

        DetritoOrbital detrito = detritoOrbitalRepository.findById(requestDto.getIdDetrito())
                .orElseThrow(() -> new ResourceNotFoundException("DetritoOrbital not found with id: " + requestDto.getIdDetrito()));

        modelMapper.map(requestDto, existingCredito);
        existingCredito.setDetrito(detrito);

        CreditoOrbital updatedCredito = creditoOrbitalRepository.save(existingCredito);
        return modelMapper.map(updatedCredito, CreditoOrbitalResponseDto.class);
    }

    public void delete(Long id) {
        CreditoOrbital credito = creditoOrbitalRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CreditoOrbital not found with id: " + id));
        creditoOrbitalRepository.delete(credito);
    }
}