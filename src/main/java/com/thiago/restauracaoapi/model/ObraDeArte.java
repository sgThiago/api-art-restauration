package com.thiago.restauracaoapi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "obras_de_arte")
public class ObraDeArte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    private String autor;
    private int ano;

    @OneToMany(mappedBy = "obraDeArte", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Evita loop infinito no JSON (lado "pai")
    private List<Restauracao> restauracoes;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public List<Restauracao> getRestauracoes() { return restauracoes; }
    public void setRestauracoes(List<Restauracao> restauracoes) { this.restauracoes = restauracoes; }
}