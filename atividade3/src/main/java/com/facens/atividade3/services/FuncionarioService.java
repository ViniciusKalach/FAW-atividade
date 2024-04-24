package com.facens.atividade3.services;

import java.util.List;

import com.facens.atividade3.dtos.DadosFuncionarioDTO;
import com.facens.atividade3.dtos.DadosProjetoDTO;
import com.facens.atividade3.dtos.FuncionarioDTO;
import com.facens.atividade3.models.Funcionario;

public interface FuncionarioService {
    Funcionario salvar(FuncionarioDTO funcionarioDTO);

    List<DadosFuncionarioDTO> listarTodos();

    List<DadosProjetoDTO> listarProjetoDTOs();

    List<DadosProjetoDTO> listarProjetoDTOsPorFuncionario(Integer funcionarioId);
}
