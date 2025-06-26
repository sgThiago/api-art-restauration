package com.thiago.restauracaoapi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "restauracoes")
public class Restauracao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String responsavel;

    private LocalDate data;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "obra_de_arte_id", nullable = false)
    @JsonBackReference // Evita loop infinito no JSON (lado "filho")
    private ObraDeArte obraDeArte;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getResponsavel() { return responsavel; }
    public void setResponsavel(String responsavel) { this.responsavel = responsavel; }
    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public ObraDeArte getObraDeArte() { return obraDeArte; }
    public void setObraDeArte(ObraDeArte obraDeArte) { this.obraDeArte = obraDeArte; }
}