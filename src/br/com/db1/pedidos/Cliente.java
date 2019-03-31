package br.com.db1.pedidos;

public class Cliente {

	
	private String nome;
	private String cpf;
	private StatusCliente status;

	public Cliente(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		this.status = StatusCliente.ATIVO;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public StatusCliente getStatus() {
		return status;
	}

	public void setStatus(StatusCliente status) {
		this.status = status;
	}

}
