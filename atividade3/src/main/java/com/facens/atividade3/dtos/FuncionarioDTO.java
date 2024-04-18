package com.facens.atividade3.dtos;

import java.util.List;

import com.facens.atividade3.models.Projeto;
import com.facens.atividade3.models.Setor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private Setor setor;
    private Integer setorId;
    private List<Projeto> projeto;
}
