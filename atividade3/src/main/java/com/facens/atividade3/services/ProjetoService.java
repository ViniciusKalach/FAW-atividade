package com.facens.atividade3.services;

import java.util.List;

import com.facens.atividade3.dtos.DadosProjetoDTO;
import com.facens.atividade3.dtos.ProjetoDTO;
import com.facens.atividade3.models.Projeto;

public interface ProjetoService {
    Projeto salvar(ProjetoDTO projetoDTO);

    List<DadosProjetoDTO> listarTodos();

    List<DadosProjetoDTO> listarFuncionarioDTOs();

    /*List<DadosFuncionarioDTO> listarFuncionarioDTOsPorProjeto(Integer id);*/

    void vincularFuncionario(Integer idProjeto, Integer idFuncionario);
}
