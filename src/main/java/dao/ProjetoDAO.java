package dao;

import model.Projeto;
import service.Conexao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProjetoDAO {
    private Connection connection;

    public ProjetoDAO() {
        this.connection = new Conexao().getConnection();
    }

    public void cadastrarProjeto(Projeto projeto) {
        String sql = "INSERT INTO projetos (titulo, descricao, dataFinal, status, usuarioId) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, projeto.getTitulo());
            stmt.setString(2, projeto.getDescricao());
            stmt.setDate(3, Date.valueOf(projeto.getDataFinal()));
            stmt.setString(4, projeto.getStatus());
            stmt.setInt(5, projeto.getUsuarioId());
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Projeto> listarProjetos() {
        List<Projeto> projetos = new ArrayList<>();
        String sql = "SELECT * FROM projetos";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setTitulo(rs.getString("titulo"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setDataFinal(rs.getDate("dataFinal").toLocalDate());
                projeto.setStatus(rs.getString("status"));
                projeto.setUsuarioId(rs.getInt("usuarioId"));
                projetos.add(projeto);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return projetos;
    }

    public Projeto buscarProjetoPorId(int id) {
        String sql = "SELECT * FROM projetos WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setTitulo(rs.getString("titulo"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setDataFinal(rs.getDate("dataFinal").toLocalDate());
                projeto.setStatus(rs.getString("status"));
                projeto.setUsuarioId(rs.getInt("usuarioId"));
                return projeto;
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public List<Projeto> listarProjetosPorUsuarioId(int usuarioId) {
        String sql = "SELECT * FROM projetos WHERE usuarioId = ?";
        List<Projeto> projetos = new ArrayList<>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, usuarioId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Projeto projeto = new Projeto();
                projeto.setTitulo(rs.getString("titulo"));
                projeto.setDescricao(rs.getString("descricao"));
                projeto.setDataFinal(rs.getDate("dataFinal").toLocalDate());
                projeto.setStatus(rs.getString("status"));
                projeto.setUsuarioId(rs.getInt("usuarioId"));
                projetos.add(projeto);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return projetos;
    }

    public void atualizarProjeto(Projeto projeto, int id) {
        String sql = "UPDATE projetos SET titulo = ?, descricao = ?, dataFinal = ?, status = ? WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, projeto.getTitulo());
            stmt.setString(2, projeto.getDescricao());
            stmt.setDate(3, Date.valueOf(projeto.getDataFinal()));
            stmt.setString(4, projeto.getStatus());
            stmt.setInt(5, id);
            stmt.executeUpdate();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deletarProjeto(int id) {
        String sql = "DELETE FROM projetos WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
