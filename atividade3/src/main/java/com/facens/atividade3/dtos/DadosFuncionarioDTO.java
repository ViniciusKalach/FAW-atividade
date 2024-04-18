package com.facens.atividade3.dtos;

import java.util.List;

import com.facens.atividade3.models.Projeto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DadosFuncionarioDTO {
    private Integer id;
    private String nome;
    private DadosSetorDTO setor;
    private Integer setorId;
    private List<Projeto> projeto;
}
