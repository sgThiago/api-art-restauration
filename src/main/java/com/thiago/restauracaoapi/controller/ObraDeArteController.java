package com.thiago.restauracaoapi.controller;

import com.thiago.restauracaoapi.model.ObraDeArte;
import com.thiago.restauracaoapi.service.ObraDeArteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/obras-de-arte")
@Tag(name = "Obras de Arte", description = "Operações CRUD para Obras de Arte")
public class ObraDeArteController {

    // O Controller chama o Service, que contém a lógica de negócio.
    @Autowired
    private ObraDeArteService service;

    @GetMapping
    @Operation(summary = "Lista todas as obras de arte")
    public List<ObraDeArte> listar() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Cria uma nova obra de arte")
    public ObraDeArte criar(@RequestBody ObraDeArte obraDeArte) {
        return service.save(obraDeArte);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma obra de arte por ID")
    public ResponseEntity<ObraDeArte> buscarPorId(@PathVariable Long id) {
        // Retorna a obra se encontrada, ou um status 404 (Not Found) se não.
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma obra de arte existente")
    public ResponseEntity<ObraDeArte> atualizar(@PathVariable Long id, @RequestBody ObraDeArte obraDeArte) {
        return service.findById(id)
                .map(existente -> {
                    existente.setTitulo(obraDeArte.getTitulo());
                    existente.setAutor(obraDeArte.getAutor());
                    existente.setAno(obraDeArte.getAno());
                    return ResponseEntity.ok(service.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma obra de arte")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        // Retorna um status 204 (No Content), indicando sucesso sem conteúdo para retornar.
        return ResponseEntity.noContent().build();
    }
}