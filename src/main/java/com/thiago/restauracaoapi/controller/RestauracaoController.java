package com.thiago.restauracaoapi.controller;

import com.thiago.restauracaoapi.model.Restauracao;
import com.thiago.restauracaoapi.service.RestauracaoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/restauracoes")
@Tag(name = "Restaurações", description = "Operações CRUD para Restaurações")
public class RestauracaoController {

    @Autowired
    private RestauracaoService service;

    @GetMapping
    @Operation(summary = "Lista todas as restaurações")
    public List<Restauracao> listar() {
        return service.findAll();
    }

    @PostMapping
    @Operation(summary = "Cria uma nova restauração para uma obra de arte")
    public Restauracao criar(@RequestBody Restauracao restauracao) {
        // Ao criar uma restauração, o corpo do JSON deve incluir o ID da obra de arte.
        // Exemplo: { "responsavel": "Equipa A", "obraDeArte": { "id": 1 } }
        return service.save(restauracao);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Busca uma restauração por ID")
    public ResponseEntity<Restauracao> buscarPorId(@PathVariable Long id) {
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualiza uma restauração existente")
    public ResponseEntity<Restauracao> atualizar(@PathVariable Long id, @RequestBody Restauracao restauracao) {
        return service.findById(id)
                .map(existente -> {
                    existente.setResponsavel(restauracao.getResponsavel());
                    existente.setData(restauracao.getData());
                    existente.setDescricao(restauracao.getDescricao());
                    existente.setObraDeArte(restauracao.getObraDeArte());
                    return ResponseEntity.ok(service.save(existente));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deleta uma restauração")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (service.findById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}