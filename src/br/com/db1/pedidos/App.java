package br.com.db1.pedidos;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		Cliente cliente1 = new Cliente("Lana Tormena", "11111111111");
		List<PedidoItem> listaEsfirra = new ArrayList<>();

		Produto esfirra1 = new Produto("001", "Esfirra de carne", 2.00);
		Produto esfirra2 = new Produto("002", "Esfirra de queijo", 2.00);
		Produto esfirra3 = new Produto("003", "Esfirra de pizza", 2.00);
		Produto esfirra4 = new Produto("004", "Esfirra de frango", 2.00);
		Produto esfirra5 = new Produto("005", "Esfirra de peixe", 2.00);
		Produto esfirra6 = new Produto("006", "Esfirra de bacon", 2.00);
		Produto esfirra7 = new Produto("007", "Esfirra de calabresa", 2.00);
		Produto esfirra8 = new Produto("008", "Esfirra de peperoni", 2.00);
		Produto esfirra9 = new Produto("009", "Esfirra de chocolate", 2.00);
		Produto esfirra10 = new Produto("010", "Esfirra de goiabada", 2.00);
		Produto esfirra11 = new Produto("011", "Esfirra de nutella", 2.00);

		PedidoItem item1 = new PedidoItem(esfirra1, 10, esfirra1.getValor());
		PedidoItem item2 = new PedidoItem(esfirra2, 12, esfirra2.getValor());

		listaEsfirra.add(item1);
		listaEsfirra.add(item2);

		Pedido pedido1 = new Pedido("001", cliente1, listaEsfirra);
		pedido1.relatorio1();
		System.out.println("-------------------------------------------------");
		pedido1.relatorio2();

	}

}
