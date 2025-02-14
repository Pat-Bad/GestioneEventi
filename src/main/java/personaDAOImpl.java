import jakarta.persistence.EntityManager;
import static org.example.EntityManagerUtil.getEntityManager;

public class personaDAOImpl implements PersonaDAO {
    EntityManager em = getEntityManager();

    @Override
    public void save(Persona persona) {

        try { em.getTransaction().begin();
            if (persona.getId() == null) {
                em.persist(persona);
            } else {
                em.merge(persona);
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
    public Persona findById(Long id) {

        try {em.getTransaction().begin();
            Persona personaCercata = em.find(Persona.class, id);
            em.getTransaction().commit();
            return personaCercata;
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
       em.getTransaction().begin();
        try {
            em.getTransaction().begin();
            Persona personaDaEliminare = em.find(Persona.class, id);
            if (personaDaEliminare != null) {
                em.remove(personaDaEliminare);
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



