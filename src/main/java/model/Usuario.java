package model;

public class Usuario {
	private int id;
	private String nome;
	private String sobrenome;
	private String email;
	private String senha;
	private static int contadorUsuario;
	
	public Usuario() {
		this.id = contadorUsuario++;
	}
	
	public Usuario(String nome, String sobrenome, String email, String senha) {
		this.id = contadorUsuario++;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public int getId() {
		return id;
	}
	
	

}
