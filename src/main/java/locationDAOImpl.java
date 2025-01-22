import jakarta.persistence.EntityManager;

public class locationDAOImpl implements LocationDAO{

    public void deleteById(Long id) {
        EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            Location LocationDaEliminare = em.find(Location.class,id);
            if (LocationDaEliminare != null)
                em.remove(LocationDaEliminare);
            em.getTransaction().commit();
        }
        catch(Exception e){ if (em.getTransaction().isActive())
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        finally{em.close();}


    }

    @Override
    public void save(Location location){
        EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            if (location.getId() == null){
                em.persist(location); //lo salvo nel db
            } else {em.merge(location);}
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
    public Location findById(Long Id) {
        EntityManager em = MainApp.getEntityManager();
        try{
            em.getTransaction().begin();
            Location locationCercata = em.find(Location.class,Id);
            em.getTransaction().commit();
            return locationCercata;
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
