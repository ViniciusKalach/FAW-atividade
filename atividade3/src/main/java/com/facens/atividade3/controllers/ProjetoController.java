package com.facens.atividade3.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facens.atividade3.dtos.DadosFuncionarioDTO;
import com.facens.atividade3.dtos.DadosProjetoDTO;
import com.facens.atividade3.dtos.ProjetoDTO;
import com.facens.atividade3.services.ProjetoService;

@RestController
@RequestMapping("api/projeto")
public class ProjetoController {
    private ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody ProjetoDTO projetoDTO) {
        projetoService.salvar(projetoDTO);
    }

    @GetMapping("/{id}")
    public List<DadosProjetoDTO> buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.listarFuncionarioDTOs();
    }

    /*@GetMapping("/{id}")
        public List<DadosFuncionarioDTO> buscarProjetoPorId(@PathVariable Integer id) {
        return projetoService.listarFuncionarioDTOsPorProjeto(id);
    }*/

    @PostMapping("/{idProjeto}/vincular-funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }
}
