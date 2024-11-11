package StepProject1;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ConsoleRepresentation {

    AviaTicketsController controller = new AviaTicketsController();
    Scanner sc = new Scanner(System.in);

    public void output(List<String[]> str) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| ID   | Destination         | Departure Date | Departure Time | Available Seats |");
        System.out.println("----------------------------------------------------------------------------------");
        for (String[] row : str) {
            int l = 19 - row[1].length();
            for (int i = 0; i < l; i++) {
                row[1] += " ";
            }
            l = 14 - row[2].length();
            for (int i = 0; i < l; i++) {
                row[2] += " ";
            }
            l = 14 - row[3].length();
            for (int i = 0; i < l; i++) {
                row[3] += " ";
            }
            l = 15 - row[4].length();
            for (int i = 0; i < l; i++) {
                row[4] += " ";
            }
            System.out.println(String.format("| %-4s | %s | %s | %s | %s |",
                    row[0], row[1], row[2], row[3], row[4]));
        }
        System.out.println("----------------------------------------------------------------------------------");
    }

    public void output(String[] row) {
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("| ID   | Destination         | Departure Date | Departure Time | Available Seats |");
        System.out.println("----------------------------------------------------------------------------------");
            int l = 19 - row[1].length();
            for (int i = 0; i < l; i++) {
                row[1] += " ";
            }
            l = 14 - row[2].length();
            for (int i = 0; i < l; i++) {
                row[2] += " ";
            }
            l = 14 - row[3].length();
            for (int i = 0; i < l; i++) {
                row[3] += " ";
            }
            l = 15 - row[4].length();
            for (int i = 0; i < l; i++) {
                row[4] += " ";
            }
            System.out.println(String.format("| %-4s | %s | %s | %s | %s |",
                    row[0], row[1], row[2], row[3], row[4]));
        System.out.println("----------------------------------------------------------------------------------");
    }

    private int readInt() {
        int number;
        while (true) {
            try {
                number = sc.nextInt();
                break;
            } catch (NumberFormatException e) {
                System.out.println("Number is incorrect type it again");
            }
        }
        return number;
    }

    private int readInt(int min, int max) {
        int number;
        while (true) {
            try {
                number = sc.nextInt();
                if (number < min || number > max) {
                    System.out.println("Number is incorrect type it again");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Number is incorrect type it again");
            }
        }
        return number;
    }

    public void StartApp() throws IOException {
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an option:\n" +
                    "1 - show all flights\n" +
                    "2 - show info about flight\n" +
                    "3 - find and reserve flight\n" +
                    "4 - cancel reservation\n" +
                    "5 - my flights\n" +
                    "6 - exit");
            String in = sc.nextLine();
            switch (in) {
                case "1":
                    output(controller.allRacesStringRepresentation());
                    break;
                case "2":
                    System.out.println("Enter flight number:");
                    output(controller.IndexedRaceStringRepresentation(readInt()));
                    break;
                case "6":
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown option");
                    break;
            }
            System.out.println("Press enter to continue...");
            String skip = sc.nextLine();
        }
    }
}
