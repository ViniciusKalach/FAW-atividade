package com.AC1.Controller;

import com.AC1.Models.CategoriasProdutos;
import com.AC1.Repository.CategoriaProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/categoria")
public class CategoriaController {

    private CategoriaProdutoRepository categoriaProdutoRepository;

    public CategoriaController(CategoriaProdutoRepository categoriaProdutoRepository){
        this.categoriaProdutoRepository = categoriaProdutoRepository;
    }

    @GetMapping
    public List<CategoriasProdutos> mostrarTodos() {
        return categoriaProdutoRepository.mostrarTodos();
    }

    @PostMapping
    public void inserir(@RequestBody CategoriasProdutos categoriasProdutos){
        categoriaProdutoRepository.inserir(categoriasProdutos);
    }
}
