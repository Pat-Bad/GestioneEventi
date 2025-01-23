import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "persona")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column (name = "nome")
    private String nome;
    @Column (name = "cognome")
    private String cognome;
    @Column (name = "email", unique = true)
    private String email;
    @Column (name = "data_di_nascita")
    private LocalDate data_di_nascita;
    @Column (name = "sesso")
    private String sesso;

    @OneToMany(mappedBy = "persona", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Partecipazione> partecipazioni = new ArrayList<>();


    //costruttori
    public Persona(){};

    public Persona (String nome, String cognome, String email, LocalDate data_di_nascita, String sesso){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
    }

    //GET E SET
    public Long getId() {
        return this.id;
    }
    public String getNome(){
        return this.nome;
    }
    public String getCognome(){
        return this.cognome;
    }
    public String getEmail(){
        return this.email;
    }
    public LocalDate getData_di_nascita(){
        return this.data_di_nascita;
    }
    public String getSesso(){
        return this.sesso;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setSesso(String sesso) {
        this.sesso = sesso;
    }
    public void setListaPartecipazioni(String listaPartecipazioni) {
    }

    //toString
    @Override
    public String toString(){
        return "Nome: " + nome + "\nCognome: " + cognome + "\nEmail: " + email;
     }

    public List<Partecipazione> getPartecipazioni() {
        return partecipazioni;
    }

    public void setPartecipazioni(List<Partecipazione> partecipazioni) {
        this.partecipazioni = partecipazioni;
    }
}
