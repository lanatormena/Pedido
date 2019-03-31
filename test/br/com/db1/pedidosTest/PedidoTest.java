package br.com.db1.pedidosTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.com.db1.pedidos.Cliente;
import br.com.db1.pedidos.Pedido;
import br.com.db1.pedidos.PedidoItem;
import br.com.db1.pedidos.Produto;
import br.com.db1.pedidos.StatusCliente;
import br.com.db1.pedidos.StatusPedido;
import br.com.db1.pedidos.StatusProduto;
import junit.framework.Assert;

public class PedidoTest {

	private Cliente cliente1;
	private List<PedidoItem> listaEsfirra;
	private Produto esfirra1;
	private Produto esfirra2;
	private Produto esfirra3;
	private Produto esfirra4;
	private Produto esfirra5;
	private Produto esfirra6;
	private Produto esfirra7;
	private Produto esfirra8;
	private Produto esfirra9;
	private Produto esfirra10;
	private Produto esfirra11;
	private PedidoItem item1;
	private PedidoItem item2;
	private Pedido pedido1;

	@Before
	public void init() {
		cliente1 = new Cliente("Lana Tormena", "11111111111");
		listaEsfirra = new ArrayList<>();

		esfirra1 = new Produto("001", "Esfirra de carne", 2.00);
		esfirra2 = new Produto("002", "Esfirra de queijo", 2.00);
		esfirra3 = new Produto("003", "Esfirra de pizza", 2.00);
		esfirra4 = new Produto("004", "Esfirra de frango", 2.00);
		esfirra5 = new Produto("005", "Esfirra de peixe", 2.00);
		esfirra6 = new Produto("006", "Esfirra de bacon", 2.00);
		esfirra7 = new Produto("007", "Esfirra de calabresa", 2.00);
		esfirra8 = new Produto("008", "Esfirra de peperoni", 2.00);
		esfirra9 = new Produto("009", "Esfirra de chocolate", 2.00);
		esfirra10 = new Produto("010", "Esfirra de goiabada", 2.00);
		esfirra11 = new Produto("011", "Esfirra de nutella", 2.00);

		item1 = new PedidoItem(esfirra1, 10, esfirra1.getValor());
		item2 = new PedidoItem(esfirra2, 12, esfirra2.getValor());
		Pedido pedido2 = new Pedido("5", cliente1, listaEsfirra);

		listaEsfirra.add(item1);
		listaEsfirra.add(item2);

	}

	// Validando cliente inativo
	@Test(expected = RuntimeException.class)
	public void deveRetornarClienteInativo() {
		cliente1.setStatus(StatusCliente.INATIVO);
		pedido1 = new Pedido("001", cliente1, listaEsfirra);
	}

	// Validando produto inativo
	@Test(expected = RuntimeException.class)
	public void deveRetornarProdutoInativo() {
		esfirra11.setStatus(StatusProduto.INATIVO);
		PedidoItem item3 = new PedidoItem(esfirra11, 6, esfirra11.getValor());
	}

	// Validando o estado do pedido
	@Test(expected = RuntimeException.class)
	public void deveRetornarStatusPedido() {
		pedido1 = new Pedido("001", cliente1, listaEsfirra);
		pedido1.setStatus(StatusPedido.FATURADO);
		pedido1.setStatus(StatusPedido.CANCELADO);
	}

	// Validando Numero do pedido
	@Test
	public void deveRetornarNumeroPedido() {
		Pedido pedidoTest = new Pedido("6", cliente1, listaEsfirra);
		pedidoTest.getNumero().equals("6");
	}

	// Verificando a data do pedido
	@Test
	public void deveRetornarDataPedido() {
		Pedido pedidoTest = new Pedido("6", cliente1, listaEsfirra);
		// Assert.assertEquals(LocalDateTime.now(), pedidoTest.getData());
		pedidoTest.getData().equals(LocalDateTime.now());
	}

	// Validando Status do pedido
	@Test
	public void deveRetornarStatusPedidoAtual() {
		pedido1 = new Pedido("001", cliente1, listaEsfirra);
		pedido1.setStatus(StatusPedido.CANCELADO);
		Assert.assertEquals(StatusPedido.CANCELADO, pedido1.getStatus());
	}

	// Validando quantidade de itens do pedido 
	@Test
	public void deveRetornarQtdeItens() {
		Pedido pedido2 = new Pedido("2", cliente1, listaEsfirra);
		Assert.assertEquals(2, listaEsfirra.size());

	}

	// Validando valor total do pedido
	@Test
	public void deveRetornarValorTotalPedido() {
		Pedido pedidoNovo = new Pedido("2", cliente1, listaEsfirra);
		Assert.assertEquals(44.0, pedidoNovo.getValorTotal(), 0.0);
	}

	// Validando código do produto
	@Test
	public void deveRetornarCodigoProduto() {
		Pedido pedido4 = new Pedido("4", cliente1, listaEsfirra);
		Assert.assertEquals("001", pedido4.getItens().get(0).getProduto().getCodigo());
		Assert.assertEquals("002", pedido4.getItens().get(1).getProduto().getCodigo());

	}

	// Validando nome do produto
	@Test
	public void deveRetornarNomeProduto() {
		Pedido pedido4 = new Pedido("4", cliente1, listaEsfirra);
		Assert.assertEquals("Esfirra de carne", pedido4.getItens().get(0).getProduto().getNome());
		Assert.assertEquals("Esfirra de queijo", pedido4.getItens().get(1).getProduto().getNome());
	}

	// Validando valor do produto
	@Test
	public void deveRetornarValorProduto() {
		Pedido pedido4 = new Pedido("4", cliente1, listaEsfirra);
		Assert.assertEquals(2.0, pedido4.getItens().get(0).getProduto().getValor());
	}

	// Validando a quantidade de produtos
	@Test
	public void deveRetornarQtdeProdutos() {
		Pedido pedido4 = new Pedido("4", cliente1, listaEsfirra);
		int qtde = 0;
		for (int i = 0; i < pedido4.getItens().size(); i++) {
			qtde = qtde + pedido4.getItens().get(i).getQtde();
		}
		Assert.assertEquals(22, qtde);
	}

}