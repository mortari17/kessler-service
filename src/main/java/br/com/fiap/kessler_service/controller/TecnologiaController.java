package br.com.fiap.kessler_service.controller;

import br.com.fiap.kessler_service.dto.TecnologiaRequestDto;
import br.com.fiap.kessler_service.dto.TecnologiaResponseDto;
import br.com.fiap.kessler_service.service.TecnologiaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tecnologias")
@RequiredArgsConstructor
public class TecnologiaController {

    private final TecnologiaService tecnologiaService;

    @GetMapping
    public ResponseEntity<List<TecnologiaResponseDto>> getAll() {
        List<TecnologiaResponseDto> list = tecnologiaService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TecnologiaResponseDto> getById(@PathVariable Long id) {
        TecnologiaResponseDto dto = tecnologiaService.findById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<TecnologiaResponseDto> create(@Valid @RequestBody TecnologiaRequestDto requestDto) {
        TecnologiaResponseDto created = tecnologiaService.create(requestDto);
        return ResponseEntity.status(201).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TecnologiaResponseDto> update(@PathVariable Long id, @Valid @RequestBody TecnologiaRequestDto requestDto) {
        TecnologiaResponseDto updated = tecnologiaService.update(id, requestDto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        tecnologiaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}