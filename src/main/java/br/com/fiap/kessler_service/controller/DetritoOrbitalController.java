package br.com.fiap.kessler_service.controller;

import br.com.fiap.kessler_service.dto.DetritoOrbitalRequestDto;
import br.com.fiap.kessler_service.dto.DetritoOrbitalResponseDto;
import br.com.fiap.kessler_service.service.DetritoOrbitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/detritos-orbitais")
@RequiredArgsConstructor
public class DetritoOrbitalController {

    private final DetritoOrbitalService service;

    @GetMapping
    public ResponseEntity<List<DetritoOrbitalResponseDto>> getAll() {
        List<DetritoOrbitalResponseDto> dtos = service.findAll();
        return ResponseEntity.ok(dtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetritoOrbitalResponseDto> getById(@PathVariable Long id) {
        DetritoOrbitalResponseDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<DetritoOrbitalResponseDto> create(@RequestBody @Valid DetritoOrbitalRequestDto requestDto) {
        DetritoOrbitalResponseDto dto = service.create(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetritoOrbitalResponseDto> update(@PathVariable Long id, @RequestBody @Valid DetritoOrbitalRequestDto requestDto) {
        DetritoOrbitalResponseDto dto = service.update(id, requestDto);
        return ResponseEntity.ok(dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}