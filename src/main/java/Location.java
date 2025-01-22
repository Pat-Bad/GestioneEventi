import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "citta")
    private String citta;
    //metto attributo che c'è in evento per collegarlo
    @OneToMany(mappedBy = "location")
    private List<Evento> listaEventi = new ArrayList<>();

    //costruttori
    public Location(){};
    public Location(String nome, String c){
        this.nome = nome;
        this.citta = c;
    }

    //GET E SET
    public Long getId() { return id;
    }
    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public List<Evento> getListaEventi() {
        return listaEventi;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public void setListaEventi(List<Evento> listaEventi) {
        this.listaEventi = listaEventi;
    }

    //TOSTRING
    @Override
    public String toString(){
        return "Dettagli location: " + citta + ", presso " + nome;
    }

    }
