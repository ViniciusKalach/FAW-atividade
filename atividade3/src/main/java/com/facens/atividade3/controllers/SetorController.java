package com.facens.atividade3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.facens.atividade3.dtos.DadosSetorDTO;
import com.facens.atividade3.dtos.SetorDTO;
import com.facens.atividade3.services.SetorService;

@RestController
@RequestMapping("api/setor")
public class SetorController {
    private SetorService setorService;

    public SetorController(SetorService setorService) {
        this.setorService = setorService;
    }

    @PostMapping("/adicionar")
    @ResponseStatus(HttpStatus.CREATED)
    public void adicionar(@RequestBody SetorDTO setorDTO) {
        setorService.salvar(setorDTO);
    }

    @GetMapping("/{idSetor}")
    public DadosSetorDTO buscarSetorPorId(@PathVariable Integer idSetor) {
        return setorService.buscarSetorPorId(idSetor);
    }
}
