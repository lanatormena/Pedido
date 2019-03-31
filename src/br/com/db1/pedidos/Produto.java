package br.com.db1.pedidos;

public class Produto {
	private String codigo;
	private String nome;
	private Double valor;
	private StatusProduto status;

	public Produto(String codigo, String nome, Double valor) {
		this.codigo = codigo;
		this.nome = nome;
		this.valor = valor;
		this.status = StatusProduto.ATIVO;
	}

	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isAtivo() {
		if (this.status == StatusProduto.ATIVO) {
			return true;
		} else {
			return false;
		}
	}

	public String getCodigo() {
		return this.codigo;
	}

	public void setStatus(StatusProduto status) {
		this.status = status;
	}

}
