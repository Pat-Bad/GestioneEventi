import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "dataEvento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipoEvento")
    private String tipoEvento;

    @Column(name = "numeroMassimoPartecipanti")
    private int numeroMassimoPartecipanti;

    //costruttore

    public Evento(String titolo, String descrizione, int numeroMassimoPartecipanti){
        this.titolo = titolo;
        this.descrizione = descrizione;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    //Metodi GET

    public Long getId(){
        return this.id;
    }
    public String getTitolo(){
        return this.titolo;
    }
    public LocalDate getDataEvento(){
        return this.dataEvento;
    }
    public String getDescrizione(){
        return this.descrizione;
    }
    public String getTipoEvento(){
        return this.tipoEvento;
    }
    public int getNumeroMassimoPartecipanti(){
        return this.numeroMassimoPartecipanti;
    }

    // metodi SET

    public void setId(Long id){
        this.id = id;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(String tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return tipoEvento + ", " + titolo + ", " + descrizione;
    }
}
