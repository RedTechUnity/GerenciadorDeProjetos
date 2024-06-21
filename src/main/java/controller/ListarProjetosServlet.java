package controller;
@WebServlet("/listar-projetos")
public class ListarProjetosServlet extends HttpServlet {

    private ProjetoDAO projetoDAO;

    public ListarProjetosServlet() {
        projetoDAO = new ProjetoDAOImpl(HibernateUtil.getSessionFactory());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Projeto> projetos = projetoDAO.buscarTodos();

        request.setAttribute("projetos", projetos);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listagem-projetos.jsp");
        dispatcher.forward(request, response);
    }
}
