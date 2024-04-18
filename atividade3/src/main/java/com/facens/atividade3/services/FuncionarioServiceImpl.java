package com.facens.atividade3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.facens.atividade3.dtos.DadosFuncionarioDTO;
import com.facens.atividade3.dtos.DadosProjetoDTO;
import com.facens.atividade3.dtos.DadosSetorDTO;
import com.facens.atividade3.dtos.FuncionarioDTO;
import com.facens.atividade3.exceptions.RegraNegocioException;
import com.facens.atividade3.models.Funcionario;
import com.facens.atividade3.models.Projeto;
import com.facens.atividade3.models.Setor;
import com.facens.atividade3.repositories.FuncionarioRepository;
import com.facens.atividade3.repositories.ProjetoRepository;
import com.facens.atividade3.repositories.SetorRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FuncionarioServiceImpl implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final SetorRepository setorRepository;
    private final ProjetoRepository projetoRepository;

    @Override
    @Transactional
    public Funcionario salvar(FuncionarioDTO funcionarioDTO) {
        Setor setor = setorRepository.findById(funcionarioDTO.getSetorId())
                .orElseThrow(
                        () -> new RegraNegocioException("Setor não encontrado"));

        Funcionario funcionario = new Funcionario();
        funcionario.setId(funcionarioDTO.getId());
        funcionario.setNome(funcionarioDTO.getNome());
        funcionario.setSetor(setor);

        return funcionarioRepository.save(funcionario);
    }

    @Override
    public List<DadosFuncionarioDTO> listarTodos() {
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
    public List<DadosProjetoDTO> listarProjetoDTOs() {
        return projetoRepository.findAll().stream().map((Projeto p) -> {
            return DadosProjetoDTO.builder()
                    .id(p.getId())
                    .descricao(p.getDescricao())
                    .dataInicio(p.getDataInicio())
                    .dataFim(p.getDataFim())
                    .funcionarios(p.getFuncionarios())
                    .build();
        }).collect(Collectors.toList());
    }

    
}