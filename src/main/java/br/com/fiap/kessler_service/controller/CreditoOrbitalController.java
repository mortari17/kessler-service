package br.com.fiap.kessler_service.controller;

import br.com.fiap.kessler_service.dto.CreditoOrbitalRequestDto;
import br.com.fiap.kessler_service.dto.CreditoOrbitalResponseDto;
import br.com.fiap.kessler_service.service.CreditoOrbitalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/creditos-orbitais")
@RequiredArgsConstructor
public class CreditoOrbitalController {

    private final CreditoOrbitalService service;

    @GetMapping
    public ResponseEntity<List<CreditoOrbitalResponseDto>> getAll() {
        List<CreditoOrbitalResponseDto> list = service.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CreditoOrbitalResponseDto> getById(@PathVariable Long id) {
        CreditoOrbitalResponseDto dto = service.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CreditoOrbitalResponseDto> create(@Valid @RequestBody CreditoOrbitalRequestDto request) {
        CreditoOrbitalResponseDto created = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CreditoOrbitalResponseDto> update(@PathVariable Long id, @Valid @RequestBody CreditoOrbitalRequestDto request) {
        CreditoOrbitalResponseDto updated = service.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}