package Homeworks.homework10;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class ConsoleApp {
    private Human[] randomMan = new Human[]{
            new Man("John", "Trump", "2000/11/10", 67),
            new Man("Brick", "Haris", "1981/16/9", 89),
            new Man("Viper", "Bank", "1970/1/8", 56),
            new Man("Axe", "Vak", "2001/27/10", 110),
            new Man("Axe", "Vak", "2001/27/10", 110),
            new Man("Void", "Hook", "1999/11/11", 148),
            new Man("Invoker", "Wex", "2005/10/10", 100)
    };
    private Human[] randomChild = new Human[]{
            new Man("Kunkka", "Wraith", "2012/27/10", 114),
            new Man("Naix", "Spirit", "2010/11/11", 132),
            new Man("Rasta", "Exort", "2005/10/8", 100),
            new Woman("Julian", "White", "2006/8/3", 76),
            new Woman("Jenny", "Bill", "2010/11/3", 54),
            new Woman("Lucy", "Beep", "2010/12/10", 89)
    };
    private Human[] randomWoman = new Human[]{
            new Woman("Lina", "Black", "2000/10/10", 100),
            new Woman("Lina", "Black", "2000/10/10", 100),
            new Woman("Luna", "Will", "1990/1/4", 99),
            new Woman("Mirana", "Meep", "1970/6/3", 88),
            new Woman("Lanaya", "Brood", "1999/7/2", 77),
            new Woman("Cm", "Loop", "1981/15/8", 111),
            new Woman("Marci", "Foor", "1980/10/11", 112)
    };



    Scanner sc = new Scanner(System.in);
    Random rand = new Random();
    FamilyService tracker = new FamilyService();

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

    private Human readHuman(String human){
        System.out.printf("Enter %s's name: ".formatted(human));
        String name = sc.next();
        System.out.printf("Enter %s's surname: ".formatted(human));
        String surname = sc.next();
        System.out.printf("Enter %s's year of birth: ".formatted(human));
        int year = readInt(1, 2025);
        System.out.printf("Enter %s's month of birth: ".formatted(human));
        int month = readInt(1, 12);
        System.out.printf("Enter %s's day of birth: ".formatted(human));
        int day = readInt(1, 31);
        String birthDate = "%s/%s/%s".formatted(Integer.toString(year), Integer.toString(month), Integer.toString(day));
        System.out.printf("Enter %s's iq: ".formatted(human));
        int iq = readInt();
        return switch (human) {
            case "mother" -> new Woman(name, surname, birthDate, iq);
            case "father" -> new Man(name, surname, birthDate, iq);
            case "boy" -> new Man(name, surname, birthDate, iq);
            case "girl" -> new Woman(name, surname, birthDate, iq);
            default -> new Human(name, surname, birthDate, iq);
        };
    }

    private Family createFamily() {
        Family family = new Family(readHuman("mother"), readHuman("father"));
        System.out.println("Family created: ");
        System.out.println(family.prettyFormat());
        return family;
    }

    private Family createRandomFamily() {
        Family family = new Family(randomWoman[rand.nextInt(8)], randomMan[rand.nextInt(7)]);
        System.out.println("Family created: ");
        System.out.println(family.prettyFormat());
        return family;
    }

    public void startApp() {
        while (true) {
            System.out.println("Select option: \n" +
                    "1 - create new family\n" +
                    "2 - create new random family\n" +
                    "3 - show all families\n" +
                    "4 - show all families with less members than\n" +
                    "5 - show all families with more members than\n" +
                    "6 - count families with amount of members equals to\n" +
                    "7 - delete family by index\n" +
                    "8 - edit family by index\n" +
                    "9 - delete all children older than\n" +
                    "10 - exit");
            int x = sc.nextInt();
            switch (x) {
                case 1:
                    createFamily();
                    break;
                case 2:
                    createRandomFamily();
                    break;
                case 3:
                    tracker.displayAllFamilies();
                    break;
                case 4:
                    System.out.print("Less than which number do you want: ");
                    int l = readInt();
                    tracker.getFamiliesLessThan(l);
                    break;
                case 5:
                    System.out.print("More than which number do you want: ");
                    int m = readInt();
                    tracker.getFamiliesLessThan(m);
            }
        }
    }
}
