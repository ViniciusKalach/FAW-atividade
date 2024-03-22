package com.AC1.Repository;

import com.AC1.Models.Produtos;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProdutoRepository {

    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Produtos inserir(Produtos produtos){
        entityManager.merge(produtos);
        return produtos;
    }

    @Transactional
    public Produtos editar(Produtos produtos){
        entityManager.merge(produtos);
        return produtos;
    }

    @Transactional
    public void excluir(Produtos produtos){
        entityManager.remove(produtos);
    }

    public List<Produtos> selecionarTodos(){
        return entityManager.createQuery("from Produtos", Produtos.class).getResultList();
    }

    public Produtos selecionarPorId(int id) {
        return entityManager.createQuery("from Produtos p where p.id = :id", Produtos.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
