package com.thiago.restauracaoapi.repository;

import com.thiago.restauracaoapi.model.ObraDeArte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ObraDeArteRepository extends JpaRepository<ObraDeArte, Long> {
    // A mágica do Spring Data JPA acontece aqui.
    // Métodos como findAll(), findById(), save(), deleteById() já estão disponíveis.
}