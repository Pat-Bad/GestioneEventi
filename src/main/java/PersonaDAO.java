public interface PersonaDAO {
    void deleteById(Long id);

    void save(Persona persona);

    Persona findById(Long Id);
}
