package StepProject1;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AviaTicketsController {
    AviaTicketsService service = new AviaTicketsService();

    public List<AviaRace> loadAllRaces() throws IOException{
        return service.loadAllRaces();
    }

    public void reserveRace(long id, String name, String surname) throws IOException{
        service.reserveRace(id, name, surname);
        service.updateRace(id);
    }

    public void deleteReservation(long id, String name, String surname) throws IOException{
        service.delete(id, name, surname);
    }

    public List<String[]> allRacesStringRepresentation() throws IOException {
        List<String> s = service.loadAllRaces().stream()
                .map(AviaRace::represent)
                .toList();
        List<String[]> list = new ArrayList<>();
        for (String str : s) {
            list.add(str.split("\\|"));
        }
        return list;
    }

    public List<String[]> userRacesStringRepresentation(String name, String surname) throws IOException {
        List<String> s = service.loadAllUsersRaces(name, surname).stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(AviaRace::represent)
                .toList();
        List<String[]> list = new ArrayList<>();
        for (String str : s) {
            list.add(str.split("\\|"));
        }
        return list;
    }

//    public String[] userIndexedRaceStringRepresentation(long id) throws IOException {
//        Optional<AviaRace> ar = service.loadUserRaceById(id);
//        String[] result = new String[5];
//        if (ar.isPresent()) {
//            result[0] = String.valueOf(ar.get().getId());
//            result[1] = ar.get().getDestination();
//            result[2] = ar.get().getDate();
//            result[3] = ar.get().getTime();
//            result[4] = String.valueOf(ar.get().getFreeSeats());
//        }
//        return result;
//    }

    public String[] IndexedRaceStringRepresentation(long id) throws IOException {
        Optional<AviaRace> ar = service.findRaceById(id);
        String[] result = new String[5];
        if (ar.isPresent()) {
            result[0] = String.valueOf(ar.get().getId());
            result[1] = ar.get().getDestination();
            result[2] = ar.get().getDate();
            result[3] = ar.get().getTime();
            result[4] = String.valueOf(ar.get().getFreeSeats());
        }
        return result;
    }
}
