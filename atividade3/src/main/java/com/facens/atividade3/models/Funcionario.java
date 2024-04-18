package com.facens.atividade3.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Funcionario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;

    @ManyToOne
    @JoinColumn(name = "setor_id")
    private Setor setor;
    
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="projeto_funcionario",
        joinColumns={@JoinColumn(name="projeto_id")},
        inverseJoinColumns={@JoinColumn(name="funcionario_id")})
    private List<Projeto> projetos;
    
    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario() {
    }

    @Override
    public String toString() {
        return "Funcionario [id=" + id + ", nome=" + nome + ", setor=" + setor + "]";
    }
}
