package com.facens.atividade3.dtos;

import java.time.LocalDate;
import java.util.List;

import com.facens.atividade3.models.Funcionario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjetoDTO {
    private Integer id;
    private String descricao;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private List<Funcionario> funcionarios;
}
