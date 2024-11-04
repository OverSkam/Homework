package Homeworks.homework8;

import java.time.LocalDate;

public class HappyFamily {
    public static void main(String[] args) {

        Woman human1 = new Woman("J", "G", "2005/10/10", 100);
        human1.describeAge();
        System.out.println(human1.toString());
    }
}
