public interface PartecipazioneDAO {

    void save(Partecipazione partecipazione);
    Partecipazione findById(Long Id);
    void deleteById(Long id);
}
