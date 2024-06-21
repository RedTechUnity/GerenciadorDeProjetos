package controller;

import model.Projeto;
import dao.ProjetoDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/CadastrarProjetoServlet")
public class CadastrarProjetoServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    public CadastrarProjetoServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        
        String titulo = request.getParameter("titulo");
        String descricao = request.getParameter("descricao");
        LocalDate dataFinal = LocalDate.parse(request.getParameter("dataFinal"));
        String status = request.getParameter("status");
        int usuarioId = Integer.parseInt(request.getParameter("usuarioId"));
        
        Projeto projeto = new Projeto();
        projeto.setTitulo(titulo);
        projeto.setDescricao(descricao);
        projeto.setDataFinal(dataFinal);
        projeto.setStatus(status);
        projeto.setUsuarioId(usuarioId);
        
        ProjetoDAO projetoDAO = new ProjetoDAO();
        projetoDAO.cadastrarProjeto(projeto);
        
        response.sendRedirect("home.jsp");
    }
}
