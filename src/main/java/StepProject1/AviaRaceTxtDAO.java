package StepProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AviaRaceTxtDAO implements AviaRaceDAO {

    private final String fileName;

    public AviaRaceTxtDAO(String fileName) { this.fileName = fileName; }

    @Override
    public void saveRace(List<AviaRace> aviaRaces) throws IOException{
        try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(fileName)))) {
            for (AviaRace ar : aviaRaces) {
                w.write(ar.represent());
                w.newLine();
            }
        }
    }

    @Override
    public void saveRace(AviaRace aviaRace) throws IOException{
        List<AviaRace> modified = new ArrayList<>();
        modified = loadAllRaces();
        modified.add(aviaRace);
        saveRace(modified);
    }


    @Override
    public void updateRace(AviaRace aviaRace) throws IOException {
        List<AviaRace> modified =loadAllRaces().stream()
                .map(m -> m.getId() == aviaRace.getId() ? aviaRace : m)
                .toList();
        saveRace(modified);
    }

    @Override
    public void deleteRace(Long id) throws IOException {
        List<AviaRace> withoutId = loadAllRaces().stream()
                .filter(ar -> ar.getId() != id)
                .toList();
        saveRace(withoutId);
    }

    @Override
    public Optional<AviaRace> loadRace(long id) throws IOException{
        return loadAllRaces().stream()
                .filter(ar -> ar.getId() == id)
                .findFirst();
    }

    @Override
    public List<AviaRace> loadAllRaces() throws IOException{
        try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
            return r.lines()
                    .map(AviaRace::fromString)
                    .toList();
        }
    }

    @Override
    public void saveInfo(List<String> strs) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(fileName)))) {
            for (String s : strs) {
                String[] splitted = s.split("\\|");
                w.write("%s|%s|%s".formatted(splitted[0], splitted[1], splitted[2]));
                w.newLine();
            }
        }
    }

    @Override
    public void saveInfo(String str) throws IOException {
        List<String> modified = new ArrayList<>(loadAllInfo());
        modified.add(str);
        saveInfo(modified);
    }

    @Override
    public void deleteInfo(Long id) throws IOException {
        List<String> modified = new ArrayList<>();
        for (String s : loadAllInfo()) {
            String[] splitted = s.split("\\|");
            if (Long.parseLong(splitted[2]) != id)
                modified.add(s);
        }
        saveInfo(modified);
    }

    @Override
    public Optional<String> loadInfo(long id) throws IOException {
        for (String s : loadAllInfo()) {
            String[] splitted = s.split("\\|");
            if (Long.parseLong(splitted[2]) == id)
                return Optional.of(s);
        }
        return Optional.empty();
    }

    @Override
    public List<String> loadAllInfo() throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
            return r.lines().toList();
        }
    }

}
