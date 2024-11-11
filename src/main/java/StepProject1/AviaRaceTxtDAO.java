package StepProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AviaRaceTxtDAO implements AviaRaceDAO {

    private final String fileName;

    public AviaRaceTxtDAO(String fileName) { this.fileName = fileName; }

    @Override
    public void save(List<AviaRace> aviaRaces) throws IOException{
        try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(fileName)))) {
            for (AviaRace ar : aviaRaces) {
                w.write(ar.represent());
                w.newLine();
            }
        }
    }

    @Override
    public void save(AviaRace aviaRace) throws IOException{
        List<AviaRace> modified = new ArrayList<>();
        modified = loadAll();
        modified.add(aviaRace);
        save(modified);
    }

    @Override
    public void update(AviaRace aviaRace) throws IOException {
        List<AviaRace> modified =loadAll().stream()
                .map(m -> m.getId() == aviaRace.getId() ? aviaRace : m)
                .toList();
        save(modified);
    }

    @Override
    public void delete(Long id) throws IOException {
        List<AviaRace> withoutId = loadAll().stream()
                .filter(ar -> ar.getId() != id)
                .toList();
        save(withoutId);
    }

    @Override
    public Optional<AviaRace> load(long id) throws IOException{
        return loadAll().stream()
                .filter(ar -> ar.getId() == id)
                .findFirst();
    }

    @Override
    public List<AviaRace> loadAll() throws IOException{
        try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
            return r.lines()
                    .map(AviaRace::fromString)
                    .toList();
        }
    }
}
