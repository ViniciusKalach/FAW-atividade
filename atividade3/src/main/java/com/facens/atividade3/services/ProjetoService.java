package com.facens.atividade3.services;

import java.util.List;

import com.facens.atividade3.dtos.DadosFuncionarioDTO;
import com.facens.atividade3.dtos.DadosProjetoDTO;
import com.facens.atividade3.dtos.ProjetoDTO;
import com.facens.atividade3.models.Projeto;

public interface ProjetoService {
    Projeto salvar(ProjetoDTO projetoDTO);

    List<DadosProjetoDTO> listarTodos();

    List<DadosFuncionarioDTO> listarFuncionarioDTOs();

    /*public void vincularFuncionario(Integer idProjeto, Integer idFuncionario){
        {
            Projeto projeto = projetoRepository.findById(idProjeto)
                    .orElseThrow(() -> new ProjetoNotFoundException("Projeto não encontrado com o ID: " + idProjeto));
    
            Funcionario funcionario = funcionarioRepository.findById(idFuncionario)
                    .orElseThrow(() -> new FuncionarioNotFoundException("Funcionário não encontrado com o ID: " + idFuncionario));
    
            projeto.adicionarFuncionario(funcionario);
            projetoRepository.save(projeto);
        }
    
    }*/
}
