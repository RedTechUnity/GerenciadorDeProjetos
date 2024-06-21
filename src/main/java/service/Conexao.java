package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static Connection getConnection() {
        try {
            // Registrar o driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            // URL do banco de dados com timezone e SSL configurados
            String url = "jdbc:mysql://localhost:3306/gerenciamento_projetos?useSSL=false&serverTimezone=UTC";
            String usuario = "root"; // Substitua pelo seu usuário do banco de dados
            String senha = ""; // Substitua pela sua senha do banco de dados
            return DriverManager.getConnection(url, usuario, senha);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Driver JDBC não encontrado", e);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao obter conexão", e);
        }
    }
}
