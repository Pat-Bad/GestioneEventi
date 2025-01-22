import jakarta.persistence.EntityManager;

public class EventoDAOImpl implements EventoDAO{
   @Override
   public void save(Evento evento){
       //chiamo l'entitymanager perché vado a modificare il db
       EntityManager em = MainApp.getEntityManager();
       //blocco TRY/CATCH PERCHE' POTREBBERO ACCADERE COSE
       try{
           em.getTransaction().begin();
           if (evento.getId() == null){
               em.persist(evento); //lo salvo nel db
           } else {em.merge(evento);}
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
    public Evento findById(Long Id) {
        EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            Evento eventoCercato = em.find(Evento.class,Id);
            em.getTransaction().commit();
            return eventoCercato;
        }
        catch(Exception e){
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            e.printStackTrace();
            return null;
        }
        finally{em.close();}
    }

    @Override
    public void deleteById(Long Id){
        EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            Evento EventoDaEliminare = em.find(Evento.class,Id);
            if (EventoDaEliminare != null)
            em.remove(EventoDaEliminare);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive())
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{em.close();}

        }
    }

