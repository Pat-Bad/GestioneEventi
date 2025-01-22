public interface EventoDAO {
    void save(Evento evento);
    Evento findById(Long Id);
    void deleteById(Long Id);
}

