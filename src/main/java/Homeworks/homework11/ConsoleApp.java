package Homeworks.homework11;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Scanner;

public class ConsoleApp {
    private final Human[] randomMan = new Human[]{
            new Man("John", "Trump", "2000/11/10", 67),
            new Man("Brick", "Haris", "1981/16/9", 89),
            new Man("Viper", "Bank", "1970/1/8", 56),
            new Man("Axe", "Vak", "2001/27/10", 110),
            new Man("Axe", "Vak", "2001/27/10", 110),
            new Man("Void", "Hook", "1999/11/11", 148),
            new Man("Invoker", "Wex", "2005/10/10", 100)
    };
    private final Human[] randomChild = new Human[]{
            new Man("Kunkka", "Wraith", "2012/27/10", 114),
            new Man("Naix", "Spirit", "2010/11/11", 132),
            new Man("Rasta", "Exort", "2005/10/8", 100),
            new Woman("Julian", "White", "2006/8/3", 76),
            new Woman("Jenny", "Bill", "2010/11/3", 54),
            new Woman("Lucy", "Beep", "2010/12/10", 89)
    };
    private final Human[] randomWoman = new Human[]{
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

    private int readIndex(int min, int max) {
        int number;
        while (true) {
            try {
                number = sc.nextInt() - 1;
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


    private Human readHuman(String human) {
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
        Family family = new Family(randomWoman[rand.nextInt(7)], randomMan[rand.nextInt(6)]);
        System.out.println("Family created: ");
        System.out.println(family.prettyFormat());
        return family;
    }

    private void bornChild(int index) {
        System.out.println("Who do you want to adopt? 1 - boy, 2 - girl");
        int i = readInt(1, 2);
        String gender = i == 1 ? "boy" : "girl";
        System.out.printf("Enter %s's name: ".formatted(gender));
        String name = sc.next();
        String surname = FamilyService.families.get(index).getFather().getSurname();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String birthDate = LocalDate.now().format(formatter);
        int iq = rand.nextInt(100) + 70;
        FamilyService.families.get(index).addChild(
                switch (gender) {
                    case "boy" -> new Man(name, surname, birthDate, iq);
                    case "girl" -> new Woman(name, surname, birthDate, iq);
                    default -> new Human(name, surname, birthDate, iq);
                });
    }

    private void adoptChild(int index) {
        System.out.println("Who do you want to born? 1 - boy, 2 - girl");
        int i = readInt(1, 2);
        String gender = i == 1 ? "boy" : "girl";
        FamilyService.families.get(index).addChild(readHuman(gender));
    }

    private void deleteOlderThan(int age){
        for (Family family : FamilyService.families)
            family.deleteAllChildrenOlderThan(age);
    }

    public void startApp() {
        boolean exit = false;
        FamilyTxtFileDAO fileTxt = new FamilyTxtFileDAO();
        while (!exit) {
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
                    "10 - load from file\n" +
                    "11 - save to file\n" +
                    "12 - exit application");
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
                    tracker.getFamiliesLessThan(readInt());
                    break;
                case 5:
                    System.out.print("More than which number do you want: ");
                    tracker.getFamiliesMoreThan(readInt());
                    break;
                case 6:
                    System.out.print("What amount of members do you want: ");
                    System.out.println("Families with this amount of members: " + tracker.countFamiliesWithMemberNumber(readInt()));
                    break;
                case 7:
                    System.out.println("Which family do you want to delete: ");
                    FamilyService.families.remove(readIndex(0, FamilyService.families.size() - 1));
                    break;
                case 8:
                    System.out.println("What do you want? 1 - born child, 2 - adopt child");
                    switch (readInt()) {
                        case 1:
                            System.out.println("Select a family by index: ");
                            bornChild(readIndex(0, FamilyService.families.size() - 1));
                            break;
                        case 2:
                            System.out.println("Select a family by index: ");
                            adoptChild(readIndex(0, FamilyService.families.size() - 1));
                            break;
                    }
                    break;
                case 9:
                    System.out.println("Older than which number do you want: ");
                    deleteOlderThan(readInt());
                    break;
                case 10:
                    FamilyService.families.clear();
                    try {
                        FamilyService.families = fileTxt.loadAll();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 11:
                    try {
                        fileTxt.save(FamilyService.families);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case 12:
                    exit = true;
                    break;
                default:
                    System.out.println("Unknown option");
                    break;
            }
        }
    }
}
