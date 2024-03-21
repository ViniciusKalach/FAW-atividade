package com.AC1;

import com.AC1.Models.CategoriasProdutos;
import com.AC1.Models.Produtos;
import com.AC1.Repository.CategoriaProdutoRepository;
import com.AC1.Repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Ac1Application {

	@Bean
	public CommandLineRunner init(@Autowired ProdutoRepository produtoRepository,
								  @Autowired CategoriaProdutoRepository categoriaProdutoRepository) {
		return args -> {
			categoriaProdutoRepository.inserir(new CategoriasProdutos(0, "limpeza", "Limpa tudo"));
			categoriaProdutoRepository.inserir(new CategoriasProdutos(0, "Bone", "Protege do sol"));

			System.out.println("*** Listar todas as categorias ***");
			List<CategoriasProdutos> listaCategorias = categoriaProdutoRepository.mostrarTodos();
			listaCategorias.forEach(System.out::println);

			produtoRepository.inserir(new Produtos(0, "Protex", 100));
			produtoRepository.inserir(new Produtos(0, "Azulão", 5));

			System.out.println("Exemplo Listar todos");
			List<Produtos> listaProdutos = produtoRepository.selecionarTodos();
			listaProdutos.forEach(System.out::println);

			var limpeza = categoriaProdutoRepository.selecionarPorId(1);
			var protex = produtoRepository.selecionarPorId(1);

			protex.setCategoriasProdutos(limpeza);
			produtoRepository.editar(protex);
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(Ac1Application.class, args);
	}

}
