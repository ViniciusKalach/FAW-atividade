package com.example.atividade2.controllers;

import com.example.atividade2.repositories.ProdutoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/produto")
public class ProdutoController {
    private ProdutoRepository produtoRepository;
    
}
