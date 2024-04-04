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

@SpringBootApplication
public class Ac1Application {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Bean
    public CommandLineRunner demo() {
        return args -> {
            
            // Criando categorias
            Categoria categoria = new Categoria("Roupa");
            categoriaRepository.save(categoria);

            // Criando produtos
            Produto produto1 = new Produto("Boné", 10.0, categoria);
            Produto produto2 = new Produto("Camiseta comum", 20.0, categoria);
            Produto produto3 = new Produto("Camiseta do São Bento", 40.0, categoria);

            produtoRepository.save(produto1);
            produtoRepository.save(produto2);
            produtoRepository.save(produto3);

			// Testando métodos de ProdutoRepository
			System.out.println("Produtos com preço maior que 20:");
			produtoRepository.findByPrecoGreaterThan(20.0).forEach(System.out::println);
	
			System.out.println("\nProdutos com preço menor ou igual a 20:");
			produtoRepository.findByPrecoLessThanOrPrecoEquals(20.0).forEach(System.out::println);
	
			System.out.println("\nProdutos com nome começando com 'Camiseta':");
			produtoRepository.findProdutoStartingWith("Camiseta").forEach(System.out::println);

            // Testando métodos de CategoriaRepository
            System.out.println("\n*** Categorias com nome começando com 'R' ***");
            categoriaRepository.findByNomeStartingWith("R").forEach(System.out::println);

            System.out.println("\n*** Categoria por ID ***");
            Categoria categoriaComProdutos = categoriaRepository.findCategoriaWithProdutosById(categoria.getId());
            System.out.println(categoriaComProdutos.getNome());
            for (Produto produto : categoriaComProdutos.getProdutos()){
                System.out.println("Produto: " + produto.getNome() + " - Preço: " + produto.getPreco());
            }
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(Ac1Application.class, args);
    }
}
