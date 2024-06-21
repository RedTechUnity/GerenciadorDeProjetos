package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDAO;
import model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email = request.getParameter("email");
	        String senha = request.getParameter("senha");

	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        Usuario usuario = usuarioDAO.buscarUsuarioPorEmailESenha(email, senha);

	        if (usuario != null) {
	            HttpSession session = request.getSession();
	            session.setAttribute("usuarioLogado", usuario);
	            response.sendRedirect("home.jsp"); // Redireciona para a página inicial após login bem-sucedido
	        } else {
	            response.sendRedirect("login.jsp?error=true"); // Redireciona de volta para a página de login com mensagem de erro
	        }
	}

}
