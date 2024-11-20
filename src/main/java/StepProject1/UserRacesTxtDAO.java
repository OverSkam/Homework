package StepProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRacesTxtDAO implements UserRacesDAO {

    private final String fileName;

    public UserRacesTxtDAO(String fileName) { this.fileName = fileName; }

    @Override
    public void save(List<String> strs) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(new File(fileName)))) {
            for (String s : strs) {
                w.write("%s".formatted(s));
                w.newLine();
            }
        }
    }

    @Override
    public void delete(Long id) throws IOException {
        List<String> modified = new ArrayList<>();
        for (String s : loadAll()) {
            String[] splitted = s.split("\\|");
            if (Long.parseLong(splitted[2]) != id)
                modified.add(s);
        }
        save(modified);
    }

    @Override
    public Optional<String> load(long id) throws IOException {
        for (String s : loadAll()) {
            String[] splitted = s.split("\\|");
            if (Long.parseLong(splitted[2]) == id)
                return Optional.of(s);
        }
        return Optional.empty();
    }

    @Override
    public List<String> loadAll() throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(new File(fileName)))) {
            return r.lines().toList();
        }
    }
}
