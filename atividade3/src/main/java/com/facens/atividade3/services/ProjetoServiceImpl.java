package com.facens.atividade3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.facens.atividade3.dtos.DadosFuncionarioDTO;
import com.facens.atividade3.dtos.DadosProjetoDTO;
import com.facens.atividade3.dtos.DadosSetorDTO;
import com.facens.atividade3.dtos.ProjetoDTO;
import com.facens.atividade3.models.Funcionario;
import com.facens.atividade3.models.Projeto;
import com.facens.atividade3.repositories.FuncionarioRepository;
import com.facens.atividade3.repositories.ProjetoRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProjetoServiceImpl implements ProjetoService{
    private final ProjetoRepository projetoRepository;
    private final FuncionarioRepository funcionarioRepository;

    @Override
    @Transactional
    public Projeto salvar(ProjetoDTO projetoDTO) {
        Projeto projeto = new Projeto();
        projeto.setId(projetoDTO.getId());
        projeto.setDescricao(projetoDTO.getDescricao());
        projeto.setDataInicio(projetoDTO.getDataInicio());
        projeto.setDataFim(projetoDTO.getDataFim());

        return projetoRepository.save(projeto);
    }

    @Override
    public List<DadosProjetoDTO> listarTodos() {
        return projetoRepository.findAll().stream().map((Projeto p) -> {
            return DadosProjetoDTO.builder()
                    .id(p.getId())
                    .descricao(p.getDescricao())
                    .dataInicio(p.getDataInicio())
                    .dataFim(p.getDataFim())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<DadosFuncionarioDTO> listarFuncionarioDTOs() {
        return funcionarioRepository.findAll().stream().map((Funcionario f) -> {
            return DadosFuncionarioDTO.builder()
                    .id(f.getId())
                    .nome(f.getNome())
                    .setor(
                        DadosSetorDTO.builder()
                                .id(f.getSetor().getId())
                                .nome(f.getSetor().getNome())
                                .build())
                    .build();
        }).collect(Collectors.toList());
    }

    @Override
    public List<DadosFuncionarioDTO> listarFuncionarioDTOsPorProjeto(Integer id) {
        Projeto projeto = projetoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Projeto não encontrado"));

        return projeto.getFuncionarios().stream().map((Funcionario f) -> {
            return DadosFuncionarioDTO.builder()
                    .id(f.getId())
                    .nome(f.getNome())
                    .setor(
                            DadosSetorDTO.builder()
                                    .id(f.getSetor().getId())
                                    .nome(f.getSetor().getNome())
                                    .build())
                    .build();
        }).collect(Collectors.toList());
    }
}
