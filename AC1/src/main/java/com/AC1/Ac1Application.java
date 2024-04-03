package com.AC1;

import com.AC1.Models.Categoria;
import com.AC1.Models.Produto;
import com.AC1.Repository.CategoriaRepository;
import com.AC1.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Ac1Application {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            // Criando produtos
            Produto produto1 = new Produto();
            produto1.setNome("Produto1");
            produto1.setPreco(10.0);

            Produto produto2 = new Produto();
            produto2.setNome("Produto2");	
            produto2.setPreco(20.0);

			Produto produto3 = new Produto();
            produto3.setNome("Produto3");
            produto3.setPreco(40.0);

            produtoRepository.saveAll(List.of(produto1, produto2, produto3));

			// Testando métodos de ProdutoRepository
			System.out.println("Produtos com preço maior que 20:");
			produtoRepository.findByPrecoMaiorQue(20.0).forEach(System.out::println);
	
			System.out.println("\nProdutos com preço menor ou igual a 20:");
			produtoRepository.findByPrecoMenorOuIgualQue(20.0).forEach(System.out::println);
	
			System.out.println("\nProdutos com nome começando com 'Produto':");
			produtoRepository.findByNome("Produto").forEach(System.out::println);

			// Criando categorias
			Categoria categoria1 = new Categoria();
			categoria1.setNome("Categoria 1");
			categoria1.setProdutos(List.of(produto1, produto2));
	
			Categoria categoria2 = new Categoria();
			categoria2.setNome("Categoria 2");
			categoria2.setProdutos(List.of(produto3));
	
			categoriaRepository.saveAll(List.of(categoria1, categoria2));

            // Testando métodos de CategoriaRepository
            System.out.println("\n*** Categorias com nome começando com 'P' ***");
            categoriaRepository.findByNome("P").forEach(System.out::println);

            System.out.println("\n*** Categoria com produtos carregados por ID ***");
            Categoria categoriaComProdutos = categoriaRepository.findCategoriaByProdutosID(categoria1.getId());
            System.out.println(categoriaComProdutos);
            categoriaComProdutos.getProdutos().forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Ac1Application.class, args);
    }
}
