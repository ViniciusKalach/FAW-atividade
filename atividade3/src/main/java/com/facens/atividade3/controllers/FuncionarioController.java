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
import com.facens.atividade3.models.Funcionario;
import com.facens.atividade3.services.FuncionarioService;

@RestController
@RequestMapping("api/funcionario")
public class FuncionarioController {
    private FuncionarioService funcionarioService;

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public Funcionario adicionar(@RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionarioService.salvar(funcionarioDTO);
    }

    @GetMapping()
    public List<ProjetoDTO> buscarFuncionarioPorId(Integer id, @RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionarioService.listarProjetoDTOs();
    }
}
