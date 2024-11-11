package StepProject1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface AviaRaceDAO{

    default void save(List<AviaRace> ars) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void save(AviaRace ar) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void update(AviaRace ar) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void delete(Long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default Optional<AviaRace> load(long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default List<AviaRace> loadAll() throws IOException {
        throw new IllegalArgumentException("TODO");
    }
}
