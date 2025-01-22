import jakarta.persistence.EntityManager;

public class personaDAOImpl implements PersonaDAO {
    @Override
    public void deleteById(Long id) {EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            Persona PersonaDaEliminare = em.find(Persona.class,id);
            if (PersonaDaEliminare != null)
                em.remove(PersonaDaEliminare);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive())
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{em.close();}


    }

    @Override
public void save(Persona persona){
    EntityManager em = MainApp.getEntityManager();
    try{
        em.getTransaction().begin();
        if (persona.getId() == null){
            em.persist(persona); //lo salvo nel db
        } else {em.merge(persona);}
        em.getTransaction().commit();
    }
    catch (Exception e){
        if(em.getTransaction().isActive())
            em.getTransaction().rollback();
        e.printStackTrace();
    }
    finally{ em.close();}
}

    @Override
    public Persona findById(Long Id) {
        EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            Persona personaCercata = em.find(Persona.class,Id);
            em.getTransaction().commit();
            return personaCercata;
        }
        catch(Exception e){
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{em.close();}
    }
}



