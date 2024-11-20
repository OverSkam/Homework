package StepProject1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AviaTicketsService {
    DAO<AviaRace> allRaces = new AviaRaceTxtDAO("all-races.txt");
    DAO<String> userRaces = new UserRacesTxtDAO("user-races.txt");

    public void saveToUsersRaces(String str) throws IOException{
        userRaces.save(str);
    }

    public void reserveRace(long id, String name, String surname) throws IOException{
        List<String> datas = new ArrayList<>(userRaces.loadAll());
        List<String> modified = new ArrayList<>();
        boolean found = false;
        for (String data : datas){
            String[] split = data.split("\\|");
            int raceId = Integer.parseInt(split[0]);
            if (raceId == id) {
                found = true;
                boolean exists = false;
                boolean first = false;
                for (String s : split) {
                    if (!first) {
                        first = true;
                        continue;
                    }
                    if (name.equals(s.split("\\$")[0]) && surname.equals(s.split("\\$")[1])) {
                        exists = true;
                        break;
                    }
                }
                if (!exists)
                    data += "|%s$%s".formatted(name, surname);
            }
            modified.add(data);
        }
        if (!found)
            modified.add("%d|%s$%s".formatted(id, name, surname));
        userRaces.save(modified);
    }

    public List<Optional<AviaRace>> loadAllUsersRaces(String name, String surname) throws IOException{
        List<Optional<AviaRace>> result = new ArrayList<>();
        List<String> datas = new ArrayList<>(userRaces.loadAll());
        for (String data : datas) {
            String[] split = data.split("\\|");
            int raceId = Integer.parseInt(split[0]);
            boolean exists = false;
            boolean first = false;
            for (String s : split) {
                if (!first) {
                    first = true;
                    continue;
                }
                if (name.equals(s.split("\\$")[0]) && surname.equals(s.split("\\$")[1])) {
                    exists = true;
                    break;
                }
            }
            if (exists)
                result.add(allRaces.load(raceId));
        }
        return result;
    }



    public void delete(Long id, String name, String surname) throws IOException {
        List<String> datas = new ArrayList<>(userRaces.loadAll());
        List<String> modified = new ArrayList<>();
        boolean feedback = false;
        for (String data : datas){
            String[] split = data.split("\\|");
            int raceId = Integer.parseInt(split[0]);
            String temp = "%d".formatted(raceId);
            boolean first = false;
            for (String s : split) {
                if (!first) {
                    first = true;
                    continue;
                }
                if (!name.equals(s.split("\\$")[0]) || !surname.equals(s.split("\\$")[1]) || raceId != id)
                    temp += "|%s$%s".formatted(s.split("\\$")[0], s.split("\\$")[1]);
                else
                    feedback = true;
            }
            modified.add(temp);
        }
        if (feedback)
            System.out.println("**Reservation was successfully canceled**");
        else
            System.out.println("**No such reservation was found**");
        userRaces.save(modified);
    }

    public List<AviaRace> loadAllRaces() throws IOException{
        return allRaces.loadAll();
    }

    public Optional<AviaRace> findRaceById(long id) throws IOException{
        return allRaces.load(id);
    }

    public void updateRace(long id) throws IOException{
        List<AviaRace> modified = allRaces.loadAll().stream()
                .map(m -> m.getId() == id ? m.decreaseSeats() : m)
                .toList();
        allRaces.save(modified);
    }
}
