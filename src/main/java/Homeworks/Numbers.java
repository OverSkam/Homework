package Homeworks;

import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        String[][] dates =  {
                {"World War II", "French Revolution", "Black Death", "World War I", "Invention of WWW", "Medical Revolution"},
                {"1939", "1789", "1346", "1914", "1989", "1400"}
        };

        int randomDateIndex = rand.nextInt(6);
        int date = Integer.parseInt(dates[1][randomDateIndex]);

        System.out.println("Let the game begin!");
        System.out.println("What is your name?");
        String name = sc.nextLine();
        System.out.printf("%s, try to guess when %s happened\n", name, dates[0][randomDateIndex]);


        while (true){
            int guess;

            try {
                guess = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Number is incorrect type it again");
                continue;
            }

            if (guess > date)
                System.out.println("The event happened earlier");
            else
                if (guess < date)
                    System.out.println("The event happened later");
                else {
                    System.out.printf("Congratulations, %s!", name);
                    break;
                }
        }
    }
}
