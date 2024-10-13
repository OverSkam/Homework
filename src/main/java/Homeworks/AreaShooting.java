package Homeworks;

import java.util.Random;
import java.util.Scanner;

public class AreaShooting {

    static void printMatrix(boolean[][] a){

        for (int i = 0; i < a.length + 1; i++)
            System.out.printf("%d|", i);
        System.out.println();

        for (int i = 0; i < a.length; i++) {
            for (int j = -1; j < a[i].length; j++) {
                    if (j == -1)
                        System.out.printf("%d|", i + 1);
                    else{
                        char c = (char) (a[i][j] ? '*' : '-');
                        System.out.printf("%c|", c);
                    }
            }
            System.out.println();
        }
    }

    static boolean checkValue(int x){
        if (x < 0){
            System.out.println("Your number is too small!");
            return false;
        }
        if (x > 4) {
            System.out.println("Your number is too big!");
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        boolean[][] a = new boolean[5][5];

        Random rand = new Random();
        Scanner sc = new Scanner(System.in);

        int x = rand.nextInt(5);
        int y = rand.nextInt(5);
        int playersX = -1, playersY = -1;

        //to prove it's possible to guess
        System.out.printf("For tester help: x: %d, y: %d", x + 1, y + 1);
        System.out.println();
        System.out.println();

        System.out.println("All Set. Get ready to rumble!");
        printMatrix(a);

        while(playersX != x || playersY != y){

            System.out.print("Select target line: ");

            try {
                playersX = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Number is incorrect type it again");
                continue;
            }
            playersX--;

            if (!checkValue(playersX))
                continue;

            System.out.print("Select target column: ");

            try {
                playersY = Integer.parseInt(sc.nextLine());
            } catch(NumberFormatException e) {
                System.out.println("Number is incorrect type it again");
                continue;
            }
            playersY--;

            if (!checkValue(playersY))
                continue;

            if (playersX != x || playersY != y){
                a[playersX][playersY] = true;
                printMatrix(a);
                System.out.println("You have missed");
            }
        }
        System.out.println("You have won!");
    }
}
