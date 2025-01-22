public interface PartecipazioneDAO {
    public static void save(Partecipazione partecipazione){};
    public static void deleteById(Long id){};
    Partecipazione findById(Long Id);
}
