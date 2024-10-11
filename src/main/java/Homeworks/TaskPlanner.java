package Homeworks;

import java.util.Scanner;

public class TaskPlanner {

    public static void main(String[] args) {

        String[][] task = {
                {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"},
                {"Homework", "Java tasks", "Basketball", "Computer Science", "Sleeping; Dancing", "Singing", "Working"}
        };

        Scanner sc = new Scanner(System.in);

        boolean exit = true;
        boolean invalid = false;

        while (exit){
            String s = (!invalid) ? "Please, input the day of the week: " : "Sorry, I don't understand you, please try again.";
            System.out.println(s);
            invalid = false;
            String day = sc.nextLine();

            switch(day.toLowerCase()){
                case "sunday":
                    System.out.printf("Your tasks for Sunday: %s", task[1][0]);
                    System.out.println();
                    break;
                case "monday":
                    System.out.printf("Your tasks for Monday: %s", task[1][1]);
                    System.out.println();
                    break;
                case "tuesday":
                    System.out.printf("Your tasks for Tuesday: %s", task[1][2]);
                    System.out.println();
                    break;
                case "wednesday":
                    System.out.printf("Your tasks for Wednesday: %s", task[1][3]);
                    System.out.println();
                    break;
                case "thursday":
                    System.out.printf("Your tasks for Thursday: %s", task[1][4]);
                    System.out.println();
                    break;
                case "friday":
                    System.out.printf("Your tasks for Friday: %s", task[1][5]);
                    System.out.println();
                    break;
                case "saturday":
                    System.out.printf("Your tasks for Saturday: %s", task[1][6]);
                    System.out.println();
                    break;
                case "exit":
                    exit = false;
                    break;
                case "change sunday":
                    System.out.printf("Please, input new tasks for Sunday");
                    System.out.println();
                    task[1][0] = sc.nextLine();
                    break;
                case "change monday":
                    System.out.printf("Please, input new tasks for Monday");
                    System.out.println();
                    task[1][1] = sc.nextLine();
                    break;
                case "change tuesday":
                    System.out.printf("Please, input new tasks for Tuesday");
                    System.out.println();
                    task[1][2] = sc.nextLine();
                    break;
                case "change wednesday":
                    System.out.printf("Please, input new tasks for Wednesday");
                    System.out.println();
                    task[1][3] = sc.nextLine();
                    break;
                case "change thursday":
                    System.out.printf("Please, input new tasks for Thursday");
                    System.out.println();
                    task[1][4] = sc.nextLine();
                    break;
                case "change friday":
                    System.out.printf("Please, input new tasks for Friday");
                    System.out.println();
                    task[1][5] = sc.nextLine();
                    break;
                case "change saturday":
                    System.out.printf("Please, input new tasks for Saturday");
                    System.out.println();
                    task[1][6] = sc.nextLine();
                    break;
                default:
                    invalid = true;
            }
        }
    }
}
