package com.thiago.restauracaoapi.service;

import com.thiago.restauracaoapi.model.Restauracao;
import com.thiago.restauracaoapi.repository.RestauracaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RestauracaoService {

    // Injeção de dependência do repositório de Restauração
    @Autowired
    private RestauracaoRepository repository;

    public List<Restauracao> findAll() {
        return repository.findAll();
    }

    public Optional<Restauracao> findById(Long id) {
        return repository.findById(id);
    }

    public Restauracao save(Restauracao restauracao) {
        return repository.save(restauracao);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}