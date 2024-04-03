package com.AC1.Repository;

import com.AC1.Models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByPrecoMaiorQue(Double valor);
    public List<Produto> findByPrecoMenorOuIgualQue(Double valor);
    public List<Produto> findByNome(String nome);
}
