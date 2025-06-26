package com.thiago.restauracaoapi.repository;

import com.thiago.restauracaoapi.model.Restauracao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestauracaoRepository extends JpaRepository<Restauracao, Long> {
    // Assim como o outro repositório, este já herda todos os métodos
    // necessários para o CRUD (Create, Read, Update, Delete) do JpaRepository.
}