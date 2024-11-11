package StepProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AviaTicketsService {
    AviaRaceDAO allRaces = new AviaRaceTxtDAO("all-races.txt");
    AviaRaceDAO userRaces = new AviaRaceTxtDAO("user-races.txt");

    public void saveToUsersRaces(AviaRace aviaRace) throws IOException{
        userRaces.save(aviaRace);
    }

    public void updateUserRaces(AviaRace aviaRace) throws IOException {
        List<AviaRace> modified = userRaces.loadAll().stream()
                .map(m -> m.getId() == aviaRace.getId() ? aviaRace : m)
                .toList();
        userRaces.update(aviaRace);
    }

    public void delete(Long id) throws IOException {
        userRaces.loadAll().remove(id);
        userRaces.delete(id);
    }

    public Optional<AviaRace> loadUserRaceById(long id) throws IOException{
        return userRaces.load(id);
    }

    public List<AviaRace> loadAllUserRaces() throws IOException{
       return userRaces.loadAll();
    }

    public List<AviaRace> loadAllRaces() throws IOException{
        return allRaces.loadAll();
    }

    public Optional<AviaRace> findRaceById(long id) throws IOException{
        return allRaces.load(id);
    }

    public List<AviaRace> findRacesByDestination(String destination) throws IOException{
        return allRaces.loadAll().stream()
                .filter(ar -> ar.getDestination().equals(destination))
                .toList();
    }
}
