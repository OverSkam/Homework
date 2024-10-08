package Homeworks;

import java.util.Arrays;
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

        int guess = 0;
        int arraySize = 0;
        int[] oldArray = new int[0];

        while (guess != date){

            try {
                guess = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Number is incorrect type it again");
                continue;
            }

            int[] newArray = Arrays.copyOf(oldArray, oldArray.length + 1);
            newArray[oldArray.length] = guess;
            oldArray = Arrays.copyOf(newArray, newArray.length);

            String result = (guess > date) ? "The event happened earlier" : "The event happened later";

            if (guess != date)
                System.out.println(result);
            else
                break;
        }
        System.out.printf("Congratulations, %s!", name);

        for (int i = 0; i < oldArray.length - 1; i++) {
            for (int j = 0; j < oldArray.length - i - 1; j++) {
                if (oldArray[j] > oldArray[j + 1]) {
                    int temp = oldArray[j];
                    oldArray[j] = oldArray[j + 1];
                    oldArray[j + 1] = temp;
                }
            }
        }

        System.out.println();
        System.out.print("Your numbers: ");

        for (int a : oldArray)
            System.out.print(a + " ");
    }
}
