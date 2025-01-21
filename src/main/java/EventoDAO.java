import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class EventoDAO {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestioneeventi");

    public static EntityManager getEntityManager(){
    return emf.createEntityManager();}

    public static void close(){
        emf.close();}

    public static void main (String[] args){
        EntityManager em = getEntityManager();

        try {
            em.getTransaction().begin();
            Evento evento1 = new Evento("Concerto", "Polyphia in Brussels", 6000);
            evento1.setDataEvento(LocalDate.of(2025,10,31));
            evento1.setTipoEvento("pubblico");
            em.persist(evento1);
            em.getTransaction().commit();
            System.out.println("Id evento creato: " + evento1.getId());
            System.out.println(evento1);

            em.getTransaction().begin();
            Evento evento2 = new Evento ("Concerto", "XG in Milan", 2000);
            evento2.setDataEvento(LocalDate.of(2028,11,25));
            evento2.setTipoEvento("pubblico");
            em.persist(evento2);
            em.getTransaction().commit();


            Long eventoId = evento1.getId();
            em.getTransaction().begin();
            Evento eventoTrovato = em.find(Evento.class, eventoId);
            em.getTransaction().commit();
            System.out.println("Evento trovato " + eventoId);



            em.getTransaction().begin();
            Evento eventoDaEliminare = em.find(Evento.class, eventoId);
            if (eventoDaEliminare !=null) {em.remove(eventoDaEliminare); System.out.println("Evento eliminato");}
            else {System.out.println("Id evento non trovato");}
            em.getTransaction().commit();

        }
        catch (Exception e) {
            if (em.getTransaction().isActive()) { em.getTransaction().rollback();
            }  e.printStackTrace();}

        finally {em.close();}
        }
    }

