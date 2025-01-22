public interface LocationDAO {
    void deleteById(Long id);




    void save(Location location);

    Location findById(Long Id);
}
