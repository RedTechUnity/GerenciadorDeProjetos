package model;

import java.time.LocalDate;

public class Projeto {
	private String titulo;
	private String descricao;
	private LocalDate dataFinal;
	private String status;
	private int usuarioId;
	
	
	public Projeto() {
	}

	public Projeto(String titulo, String descricao, LocalDate dataFinal, String status, int usuarioId) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataFinal = dataFinal;
		this.status = status;
		this.usuarioId = usuarioId;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataFinal() {
		return dataFinal;
	}
	public void setDataFinal(LocalDate dataFinal) {
		this.dataFinal = dataFinal;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getUsuarioId() {
		return usuarioId;
	}
	public void setUsuarioId(int usuarioId) {
		this.usuarioId = usuarioId;
	}
	
}
