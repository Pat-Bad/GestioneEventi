import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static org.example.EntityManagerUtil.getEntityManager;

public class partecipazioneDAOImpl implements PartecipazioneDAO {
    EntityManager em = getEntityManager();


    public void save(Partecipazione partecipazione) {

        try {em.getTransaction().begin();
            if (partecipazione.getId() == null) {
                em.persist(partecipazione); // Insert new Partecipazione
            } else {
                em.merge(partecipazione); // Update existing Partecipazione
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }finally {em.close();}
    }

    @Override
    public Partecipazione findById(Long id) {


        try {em.getTransaction().begin();

            Partecipazione partecipazioneCercata = em.find(Partecipazione.class, id);
            em.getTransaction().commit();
            return partecipazioneCercata;
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
            em.getTransaction().begin();
            Partecipazione partecipazioneDaEliminare = em.find(Partecipazione.class, id);
            if (partecipazioneDaEliminare != null) {
                em.remove(partecipazioneDaEliminare);
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