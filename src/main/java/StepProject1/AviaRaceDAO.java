package StepProject1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

interface AviaRaceDAO{

    default void saveRace(List<AviaRace> ars) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void saveRace(AviaRace ar) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void updateRace(AviaRace ar) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void deleteRace(Long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default Optional<AviaRace> loadRace(long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default List<AviaRace> loadAllRaces() throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void saveInfo(List<String> strs) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void saveInfo(String str) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default void deleteInfo(Long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default Optional<String> loadInfo(long id) throws IOException {
        throw new IllegalArgumentException("TODO");
    }
    default List<String> loadAllInfo() throws IOException {
        throw new IllegalArgumentException("TODO");
    }
}
