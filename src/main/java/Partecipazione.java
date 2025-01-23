import jakarta.persistence.*;

@Entity
@Table (name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona persona;
    @Column (name = "stato")
    private String stato;
    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    //costruttori
    public Partecipazione(){};

    public Long getId() {
        return id;
    }

    public Partecipazione( Persona p, Evento e, String s){
        this.persona = p;
        this.evento = e;
        this.stato = s;
    }

    //GET E SET

    public Persona getPersona() {
        return persona;
    }
    public Evento getEvento() {
        return evento;
    }
    public String getStato() {
        return stato;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public void setEvento(Evento evento) {
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
