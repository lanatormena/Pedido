package br.com.db1.pedidos;

import java.time.LocalDateTime;

public class Historico {
	private LocalDateTime data;
	private StatusPedido statusPedido;

	public Historico(StatusPedido status, LocalDateTime dataHora) {
		this.statusPedido = status;
		this.data = dataHora;
	}

	public LocalDateTime getData() {
		return this.data;
	}

	public StatusPedido getStatus() {
		return this.statusPedido;
	}
}
