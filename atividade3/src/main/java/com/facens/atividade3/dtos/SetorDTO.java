package com.facens.atividade3.dtos;

import java.util.List;

import com.facens.atividade3.models.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SetorDTO {
    private Integer id;
    private String nome;
    private List<Funcionario> funcionarios;
}
