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
    //ONETOONE CON L'EVENTO. un evento ha una location
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name= "evento_id")
    private Evento evento_id;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    //TOSTRING
    @Override
    public String toString(){
        return "Dettagli location: " + citta + ", presso " + nome;
    }

    }
