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
        emf.close();}

    public static void main (String[] args){
        Evento concerto = new Evento ("Twice in Milan", "Second world tour", 8000);
        EventoDAO ed = new EventoDAOImpl();
        concerto.setDataEvento(LocalDate.of(2025,11,5));
        ed.save(concerto);

    Persona persona1 = new Persona ("Patricia", "Badji", "ciao@ciao.com", LocalDate.of(1989,06,29), "F");
    persona1.setListaPartecipazioni("idk");
    PersonaDAO pd = new personaDAOImpl();
    pd.save(persona1);

    Location location1 = new Location("Mediolanum Forum", "Milano");
    LocationDAO ld = new locationDAOImpl();
    ld.save(location1);
    
            }


}
