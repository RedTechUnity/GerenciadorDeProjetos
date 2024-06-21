public class ProjetoDAO implements Projeto {

    private SessionFactory sessionFactory;

    public ProjetoDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void salvar(Projeto projeto) {
        Session session = sessionFactory.getCurrentSession();
        session.save(projeto);
    }

    @Override
    public List<Projeto> buscarTodos() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Projeto", Projeto.class).list();
    }
}
