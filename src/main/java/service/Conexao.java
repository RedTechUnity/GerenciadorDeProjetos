package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public Connection getConnection() {
		try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/gerenciamento_projetos", "root", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
	}
}
