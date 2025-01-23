import jakarta.persistence.EntityManager;
import java.time.LocalDate;
import static org.example.EntityManagerUtil.getEntityManager;

public class MainApp {

    public static void main(String[] args) {
        EntityManager em = getEntityManager();
        EventoDAO eventoDAO = new EventoDAOImpl();
        PersonaDAO personaDAO = new personaDAOImpl();
        PartecipazioneDAO partecipazioneDAO = new partecipazioneDAOImpl();

        Evento concerto = new Evento("Twice in Milan", "Second world tour", 8000);
        concerto.setDataEvento(LocalDate.of(2025, 11, 5));
        concerto.setTipoEvento("Concerto");
        eventoDAO.save(concerto);

        Persona persona1 = new Persona("Patricia", "Badji", "ciao@ciao.com", LocalDate.of(1989, 6, 29), "F");
        personaDAO.save(persona1);

        Partecipazione partecipazione = new Partecipazione();
        partecipazione.setEvento(concerto);
        partecipazione.setPersona(persona1);
        partecipazioneDAO.save(partecipazione);

        Partecipazione partecipazioneTrovata = partecipazioneDAO.findById(partecipazione.getId());
        System.out.println("Partecipazione trovata: " + partecipazioneTrovata.getId());
        

    }
}
