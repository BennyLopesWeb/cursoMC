package com.benigno.cursoMC;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benigno.cursoMC.domain.Categoria;
import com.benigno.cursoMC.domain.Cidade;
import com.benigno.cursoMC.domain.Estado;
import com.benigno.cursoMC.domain.Produto;
import com.benigno.cursoMC.repositories.CategoriaRepository;
import com.benigno.cursoMC.repositories.CidadeRepository;
import com.benigno.cursoMC.repositories.EstadoRepository;
import com.benigno.cursoMC.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoMcApplication  implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository ;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@Autowired
	private EstadoRepository estadoRepository;
	
	@Autowired
	private CidadeRepository cidadeRepository;
	
			
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		//categoriaRepository.save(Array. (cat1, cat2));  Deprecate
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 = new Estado (null,  "Minas Gerais");
		Estado est2 = new Estado (null,  "São Paulo");
		Estado est3 = new Estado(null, "Santa Catarina");
		Estado est4 = new Estado(null, "Parana");
		Estado est5 = new Estado(null, "Rio Grande do Sul");
		Estado est6 = new Estado(null, "Rio de Janeiro");
		Estado est7 = new Estado(null, "Pernambuco");
		
		Cidade cid1 = new Cidade(null, "Uberlandia", est1);
		Cidade cid2 = new Cidade(null, "São Paulo", est2);
		Cidade cid3 = new Cidade(null, "Campinas", est2);
		Cidade cid4 = new Cidade(null, "Florianópollis", est3);
		Cidade cid5= new Cidade(null, "Curutiba", est4);
		Cidade cid6= new Cidade(null, "Joinville", est3);
		Cidade cid7= new Cidade(null, "Maringa", est4);
		Cidade cid8= new Cidade(null, "Rio Janeiro", est6);
		Cidade cid9= new Cidade(null, "Porto Alegre", est5);
		Cidade cid10= new Cidade(null, "Recife", est7);
		Cidade cid11= new Cidade(null, "Niteroi", est6);
		
		est1.getCidades().addAll(Arrays.asList(cid1));
		est2.getCidades().addAll(Arrays.asList(cid2, cid3));
		est3.getCidades().addAll(Arrays.asList(cid4, cid6));
		est4.getCidades().addAll(Arrays.asList(cid5, cid7));
		est5.getCidades().addAll(Arrays.asList(cid9));
		est6.getCidades().addAll(Arrays.asList(cid8, cid11));
		est7.getCidades().addAll(Arrays.asList(cid10));
		
		estadoRepository.saveAll( Arrays.asList (est1, est2,est3, est4, est5, est6, est7));
		
		cidadeRepository.saveAll (Arrays.asList (cid1, cid2, cid3, cid4, cid5, cid6, cid7, cid8, cid9, cid10, cid11));
		
	}

}
