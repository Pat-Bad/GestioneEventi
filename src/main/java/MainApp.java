import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class MainApp {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("gestioneeventi");

    public static EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public static void close() {
        emf.close();
    }

    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        EventoDAO eventoDAO = new EventoDAOImpl(em);
        PersonaDAO personaDAO = new personaDAOImpl(em);
        PartecipazioneDAO partecipazioneDAO = new partecipazioneDAOImpl(em);

        try {
            // Create and save an Evento
            Evento concerto = new Evento("Twice in Milan", "Second world tour", 8000);
            concerto.setDataEvento(LocalDate.of(2025, 11, 5));
            eventoDAO.save(concerto);

            // Create and save a Persona
            Persona persona1 = new Persona("Patricia", "Badji", "ciao@ciao.com", LocalDate.of(1989, 6, 29), "F");
            personaDAO.save(persona1);

            // Create and save a Partecipazione
            Partecipazione partecipazione = new Partecipazione();
            partecipazione.setEvento(concerto);
            partecipazione.setPersona(persona1);
            PartecipazioneDAO.save(partecipazione);

            // Find and print the Partecipazione
            Partecipazione partecipazioneTrovata = partecipazioneDAO.findById(partecipazione.getId());
            System.out.println("Partecipazione trovata: " + partecipazioneTrovata.getId());
        } finally {
            em.close();
            close();
        }
    }
}