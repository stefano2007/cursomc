package com.stefanoferreira.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.stefanoferreira.cursomc.Repository.CategoriaRepository;
import com.stefanoferreira.cursomc.Repository.CidadeRepository;
import com.stefanoferreira.cursomc.Repository.ClienteRepository;
import com.stefanoferreira.cursomc.Repository.EnderecoRepository;
import com.stefanoferreira.cursomc.Repository.EstadoRepository;
import com.stefanoferreira.cursomc.Repository.ProdutoRepository;
import com.stefanoferreira.cursomc.domain.Categoria;
import com.stefanoferreira.cursomc.domain.Cidade;
import com.stefanoferreira.cursomc.domain.Cliente;
import com.stefanoferreira.cursomc.domain.Endereco;
import com.stefanoferreira.cursomc.domain.Estado;
import com.stefanoferreira.cursomc.domain.Produto;
import com.stefanoferreira.cursomc.domain.enums.TipoCliente;

@SpringBootApplication

public class CursomcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;	
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CursomcApplication.class, args);
	}

	
	@Override
    public void run(String... args) throws Exception {	

		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null,"Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));		
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));		
		
		System.out.println("Categoria e Produtos.");
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2 ,p3));		
		System.out.println("Categoria e Produtos OK.");
		
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		System.out.println("Estado OK.");
		Cidade c1 = new Cidade(null, "Uberlância", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		System.out.println("Cidade OK.");
		
		System.out.println("Estado e Cidade.");
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1, c2, c3));
		System.out.println("Estado e Cidade OK.");
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores","300", "Apto 303", "Jardim", "38220834", cli1, c1 );
		Endereco e2 = new Endereco(null, "Avenida Matos", "105","Sala 800", "Centro", "3877012", cli1, c2 );
		
		cli1.getEnderecos().addAll(Arrays.asList(e1, e2));
		
		System.out.println("Cliente e Endereco.");
	    clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1 ,e2));
		System.out.println("Cliente e Endereco.");
		
	}
}
