package StepProject1;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface UserRacesDAO extends DAO<String>{
    default void save(List<String> strs) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void save(String str) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void delete(Long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default Optional<String> load(long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default List<String> loadAll() throws IOException {
        throw new IllegalArgumentException("TODO");
    }
}
