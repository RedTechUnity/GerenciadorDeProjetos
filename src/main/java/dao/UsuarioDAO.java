package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Usuario;
import service.Conexao;

public class UsuarioDAO {
	private Connection connection;
	
	public UsuarioDAO() {
		this.connection= new Conexao().getConnection();
	}
	
	 public void cadastrarUsuario(Usuario usuario) {
	        String sql = "INSERT INTO usuarios (nome, sobrenome, email, senha) VALUES (?, ?, ?, ?)";

	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, usuario.getNome());
	            stmt.setString(1, usuario.getSobrenome());
	            stmt.setString(2, usuario.getEmail());
	            stmt.setString(3, usuario.getSenha());
	            stmt.execute();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	 
	 public Usuario buscarUsuarioPorEmailESenha(String email, String senha) {
	        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
	        try {
	            PreparedStatement stmt = connection.prepareStatement(sql);
	            stmt.setString(1, email);
	            stmt.setString(2, senha);
	            ResultSet rs = stmt.executeQuery();

	            if (rs.next()) {
	                Usuario usuario = new Usuario();
	                usuario.setNome(rs.getString("nome"));
	                usuario.setSobrenome(rs.getString("sobrenome"));
	                usuario.setEmail(rs.getString("email"));
	                usuario.setSenha(rs.getString("senha"));
	                return usuario;
	            }

	            rs.close();
	            stmt.close();
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	        return null;
	    }
	
	
	
	
}
