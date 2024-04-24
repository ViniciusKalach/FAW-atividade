package com.facens.atividade3.dtos;

import java.util.List;

import com.facens.atividade3.models.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosSetorDTO {
    private Integer id;
    private String nome;
    private List<Funcionario> funcionarios;
}
