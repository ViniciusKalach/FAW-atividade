package com.facens.atividade3.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.facens.atividade3.dtos.FuncionarioDTO;
import com.facens.atividade3.dtos.ProjetoDTO;
import com.facens.atividade3.models.Projeto;
import com.facens.atividade3.services.ProjetoService;

@RestController
@RequestMapping("api/projeto")
public class ProjetoController {
    private ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Projeto adicionar(@RequestBody ProjetoDTO projetoDTO) {
        return projetoService.salvar(projetoDTO);
    }

    @GetMapping()
    public List<FuncionarioDTO> buscarProjetoPorId(Integer id, @RequestBody ProjetoDTO projetoDTO) {
        return projetoService.listarFuncionarioDTOs();
    }

    /* @PostMapping("/{idProjeto}/vincular-funcionario/{idFuncionario}")
    public void vincularFuncionario(@PathVariable Integer idProjeto, @PathVariable Integer idFuncionario) {
        projetoService.vincularFuncionario(idProjeto, idFuncionario);
    }*/
}
