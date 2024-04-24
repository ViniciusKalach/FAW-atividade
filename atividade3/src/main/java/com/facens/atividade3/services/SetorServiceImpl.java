package com.facens.atividade3.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.facens.atividade3.dtos.DadosSetorDTO;
import com.facens.atividade3.dtos.SetorDTO;
import com.facens.atividade3.exceptions.RegraNegocioException;
import com.facens.atividade3.models.Setor;
import com.facens.atividade3.repositories.SetorRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SetorServiceImpl implements SetorService{
    private final SetorRepository setorRepository;

    @Override
    public Setor salvar(SetorDTO setorDTO) {
        Setor setor = new Setor();
        setor.setNome(setorDTO.getNome());
        return setorRepository.save(setor);
    }

    @Override
    public List<SetorDTO> listarTodos() {
        return setorRepository.findAll().stream()
                .map(setor -> new SetorDTO(setor.getId(), setor.getNome()))
                .collect(Collectors.toList());
    }

    @Override
    public DadosSetorDTO buscarSetorPorId(Integer idSetor) {
        Setor setor = setorRepository.findById(idSetor)
                .orElseThrow(() -> new RegraNegocioException("Setor não encontrado"));
        
        return new DadosSetorDTO(setor.getId(), setor.getNome(), setor.getFuncionarios());
    }
}
