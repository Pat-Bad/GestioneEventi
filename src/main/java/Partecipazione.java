import jakarta.persistence.*;

@Entity
@Table (name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "persona")
    private String persona;
    @Column (name = "evento")
    private String evento;
    @Column (name = "stato")
    private String stato;

    //costruttori
    public Partecipazione(){};

    public Long getId() {
        return id;
    }

    public Partecipazione(String p, String e, String s){
        this.persona = p;
        this.evento = e;
        this.stato = s;
    }

    //GET E SET

    public String getPersona() {
        return persona;
    }
    public String getEvento() {
        return evento;
    }
    public String getStato() {
        return stato;
    }

    public void setPersona(String persona) {
        this.persona = persona;
    }

    public void setEvento(String evento) {
        this.evento = evento;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }
    //TO STRING
    @Override
    public String toString(){
        return "Dati della partecipazione: "
                + "\nPersona: " + persona + "\nNome Evento: " + evento + "\nStato: " + stato;
    }
}
