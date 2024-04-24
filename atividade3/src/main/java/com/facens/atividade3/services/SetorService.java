package com.facens.atividade3.services;

import java.util.List;

import com.facens.atividade3.dtos.DadosSetorDTO;
import com.facens.atividade3.dtos.SetorDTO;
import com.facens.atividade3.models.Setor;

public interface SetorService {
    Setor salvar(SetorDTO setorDTO);

    List<SetorDTO> listarTodos();

    DadosSetorDTO buscarSetorPorId(Integer idSetor);
}
