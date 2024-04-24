package com.facens.atividade3.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioDTO {
    private Integer id;
    private String nome;
    private Integer setorId;
    private List<Integer> projetoIds;
}
