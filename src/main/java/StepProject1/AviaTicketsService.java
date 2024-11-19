package StepProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AviaTicketsService {
    AviaRaceDAO allRaces = new AviaRaceTxtDAO("all-races.txt");
    AviaRaceDAO userRaces = new AviaRaceTxtDAO("user-races.txt");

    public void saveToUsersRaces(AviaRace aviaRace) throws IOException{
        userRaces.saveRace(aviaRace);
    }

    public void reserveRace(String name, String surname, long id) throws IOException{
        userRaces.saveInfo("%s|%s|%d".formatted(name, surname, id));
    }

    public List<Optional<AviaRace>> loadAllUsersRaces(String name, String surname) throws IOException{
        List<String> loaded = userRaces.loadAllInfo();
        return loaded.stream()
                .filter(x -> x.split("\\|")[0].equals(name) && x.split("\\|")[1].equals(surname))
                .map(x -> {
                    try {
                        return allRaces.loadRace(Long.parseLong(x.split("\\|")[2]));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                .filter(Optional::isPresent)
                .toList();
    }

    public void updateUserRaces(AviaRace aviaRace) throws IOException {
        List<AviaRace> modified = userRaces.loadAllRaces().stream()
                .map(m -> m.getId() == aviaRace.getId() ? aviaRace : m)
                .toList();
        userRaces.updateRace(aviaRace);
    }

    public void delete(Long id) throws IOException {
        userRaces.deleteRace(id);
    }

    public List<AviaRace> loadAllRaces() throws IOException{
        return allRaces.loadAllRaces();
    }

    public Optional<AviaRace> findRaceById(long id) throws IOException{
        return allRaces.loadRace(id);
    }

    public List<AviaRace> findRacesByDestination(String destination) throws IOException{
        return allRaces.loadAllRaces().stream()
                .filter(ar -> ar.getDestination().equals(destination))
                .toList();
    }
}
