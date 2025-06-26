package com.thiago.restauracaoapi.service;

import com.thiago.restauracaoapi.model.ObraDeArte;
import com.thiago.restauracaoapi.repository.ObraDeArteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ObraDeArteService {

    // Injeção de dependência: O Spring vai fornecer uma instância do nosso repositório.
    @Autowired
    private ObraDeArteRepository repository;

    // A camada de serviço chama os métodos do repositório.
    // Para um CRUD simples, parece repetitivo, mas em lógicas mais complexas
    // é aqui que as regras de negócio seriam aplicadas.

    public List<ObraDeArte> findAll() {
        return repository.findAll();
    }

    public Optional<ObraDeArte> findById(Long id) {
        return repository.findById(id);
    }

    public ObraDeArte save(ObraDeArte obraDeArte) {
        return repository.save(obraDeArte);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}