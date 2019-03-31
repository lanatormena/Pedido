package br.com.db1.pedidos;

public class PedidoItem {
	private Produto produto;
	private Integer quantidade;
	private Double valor;

	public PedidoItem(Produto produto, int quantidade, Double valor) {
		validaProduto(produto);
		verificaADDQuantidade(quantidade);
		this.valor = valor;

	}

	private void verificaADDQuantidade(int q) {
		if (q > 0) {
			this.quantidade = q;
		} else {
			throw new RuntimeException("A quantidade deve ser maior que zero, quantidade atual: " + q);
		}

	}

	private void validaProduto(Produto produto) {
		if (produto.isAtivo()) {
			this.produto = produto;
		} else {
			throw new RuntimeException("Produto intativo: " + produto.getNome());
		}
	}

	public Double getValor() {
		return this.valor;
	}

	public int getQtde() {
		return this.quantidade;
	}
	
	public Produto getProduto() {
		return this.produto;
	}

}
