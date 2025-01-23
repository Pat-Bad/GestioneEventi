import jakarta.persistence.EntityManager;
import static org.example.EntityManagerUtil.getEntityManager;

public class EventoDAOImpl implements EventoDAO {
    EntityManager em = getEntityManager();

    @Override
    public void save(Evento evento) {


        try {em.getTransaction().begin();
            if (evento.getId() == null) {
                em.persist(evento);
            } else {
                em.merge(evento);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {em.close();}
    }

    @Override
    public Evento findById(Long id) {

        try {em.getTransaction().begin();
            Evento eventoCercato = em.find(Evento.class, id);
            em.getTransaction().commit();
            return eventoCercato;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return null;
        } finally {em.close();}
    }

    @Override
    public void deleteById(Long id) {
        try {em.getTransaction().begin();


            Evento eventoDaEliminare = em.find(Evento.class, id);
            if (eventoDaEliminare != null) {
                em.remove(eventoDaEliminare);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {em.close();}
    }
}

