package br.com.fiap.kessler_service.controller;

import br.com.fiap.kessler_service.dto.MissaoRequestDto;
import br.com.fiap.kessler_service.dto.MissaoResponseDto;
import br.com.fiap.kessler_service.service.MissaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/missoes")
@RequiredArgsConstructor
public class MissaoController {

    private final MissaoService missaoService;

    @GetMapping
    public ResponseEntity<List<MissaoResponseDto>> getAllMissoes() {
        List<MissaoResponseDto> missoes = missaoService.findAll();
        return ResponseEntity.ok(missoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MissaoResponseDto> getMissaoById(@PathVariable Long id) {
        MissaoResponseDto missao = missaoService.findById(id);
        return ResponseEntity.ok(missao);
    }

    @PostMapping
    public ResponseEntity<MissaoResponseDto> createMissao(@RequestBody @Valid MissaoRequestDto request) {
        MissaoResponseDto created = missaoService.create(request);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MissaoResponseDto> updateMissao(@PathVariable Long id,
                                                          @RequestBody @Valid MissaoRequestDto request) {
        MissaoResponseDto updated = missaoService.update(id, request);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMissao(@PathVariable Long id) {
        missaoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}