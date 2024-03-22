package com.AC1.Repository;

import com.AC1.Models.CategoriasProdutos;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriaProdutoRepository {

    @Autowired
    private EntityManager entityManeger;

    @Transactional
    public CategoriasProdutos inserir(CategoriasProdutos categoriasProdutos){
        entityManeger.merge(categoriasProdutos);
        return categoriasProdutos;
    }

    @Transactional
    public CategoriasProdutos editar(CategoriasProdutos categoriasProdutos){
        entityManeger.merge(categoriasProdutos);
        return categoriasProdutos;
    }

    @Transactional
    public void excluir(CategoriasProdutos categoriasProdutos){
        entityManeger.remove(categoriasProdutos);
    }

    public List<CategoriasProdutos> mostrarTodos(){
        return entityManeger.createQuery("SELECT c from CategoriasProdutos c", CategoriasProdutos.class).getResultList();
    }

    public CategoriasProdutos selecionarPorId(int id) {
        return entityManeger.createQuery("from CategoriasProdutos p where p.id = :id", CategoriasProdutos.class)
                .setParameter("id", id)
                .getSingleResult();
    }



}
