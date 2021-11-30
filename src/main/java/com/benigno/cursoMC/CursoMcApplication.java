package com.benigno.cursoMC;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.benigno.cursoMC.domain.Categoria;
import com.benigno.cursoMC.domain.Cidade;
import com.benigno.cursoMC.domain.Cliente;
import com.benigno.cursoMC.domain.Endereco;
import com.benigno.cursoMC.domain.Estado;
import com.benigno.cursoMC.domain.ItemPedido;
import com.benigno.cursoMC.domain.Pagamento;
import com.benigno.cursoMC.domain.PagamentoComBoleto;
import com.benigno.cursoMC.domain.PagamentoComCartao;
import com.benigno.cursoMC.domain.Pedido;
import com.benigno.cursoMC.domain.Produto;
import com.benigno.cursoMC.domain.enums.EstadoPagamento;
import com.benigno.cursoMC.domain.enums.TipoCliente;
import com.benigno.cursoMC.repositories.CategoriaRepository;
import com.benigno.cursoMC.repositories.CidadeRepository;
import com.benigno.cursoMC.repositories.ClienteRepository;
import com.benigno.cursoMC.repositories.EnderecoRepository;
import com.benigno.cursoMC.repositories.EstadoRepository;
import com.benigno.cursoMC.repositories.ItemPedidoRepository;
import com.benigno.cursoMC.repositories.PagamentoRepository;
import com.benigno.cursoMC.repositories.PedidoRepository;
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
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
			
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
		
		Cliente cli1 = new Cliente(null, "Maria Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOA_FISICA);
		cli1.getTelefones().addAll(Arrays.asList("27363323", "93838393"));
		
		Endereco e1 = new Endereco(null, "Rua FLores", "300", "Apto 303", "Jardim", "38220834", cli1, cid1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, cid2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm"); 
		Pedido pedido1 = new Pedido(null, sdf.parse("30/09/2017 10:32 ") ,  cli1, e1);
		Pedido pedido2 = new Pedido(null, sdf.parse("10/10/2017 19:35 ") ,  cli1, e2);
		
		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pagto1);
		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE,  pedido2,  sdf.parse("20/10/2017 00:00"), null);
		pedido2.setPagamento(pagto2);
		
		cli1.getPedidos().addAll(Arrays.asList(pedido1, pedido2));
		
		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		
		pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));
		
		ItemPedido ip1 = new ItemPedido(pedido1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(pedido1, p3, 2.00, 1, 80.00);
		ItemPedido ip3 = new ItemPedido(pedido2, p2, 100.00, 1, 800.00);
		
		pedido1.getItens().addAll(Arrays.asList(ip1,ip2));
		pedido2.getItens().addAll(Arrays.asList(ip3));
		
		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
		p3.getItens().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1, ip2, ip3));
		
	}

}
