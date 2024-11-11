package StepProject1;

public class AviaRace {
    private long id;
    private String destination;
    private String date;
    private String time;
    private int freeSeats;

    public AviaRace(long id, String destination, String date, String time, int freeSeats) {
        this.id = id;
        this.destination = destination;
        this.date = date;
        this.time = time;
        this.freeSeats = freeSeats;
    }

    public long getId() { return id; }
    public String getDestination() { return destination; }
    public String getDate() { return date; }
    public String getTime() { return time; }
    public int getFreeSeats() { return freeSeats; }
    public void setId(long id) { this.id = id; }
    public void setDestination(String destination) { this.destination = destination; }
    public void setDate(String date) { this.date = date; }
    public void setTime(String time) { this.time = time; }
    public void setFreeSeats(int freeSeats) { this.freeSeats = freeSeats; }

    public static AviaRace fromString(String input){
        String[] data = input.split("\\|");
        return new AviaRace(Integer.parseInt(data[0]), data[1], data[2], data[3], Integer.parseInt(data[4]));
    }

    public String represent(){
        return String.format("%d|%s|%s|%s|%d", id, destination, date, time, freeSeats);
    }

    @Override
    public String toString() {
        return String.format("| %-5d | %-20s | %-12s | %-8s | %-15d |",
                id, destination, date, time, freeSeats);
    }
}
