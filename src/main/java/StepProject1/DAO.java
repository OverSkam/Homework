package StepProject1;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

interface DAO<A> {
    default void save(List<A> list) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void save(A a) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void update(A a) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void delete(Long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default Optional<A> load(long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default List<A> loadAll() throws IOException {
        throw new IllegalArgumentException("TODO");
    }
}
