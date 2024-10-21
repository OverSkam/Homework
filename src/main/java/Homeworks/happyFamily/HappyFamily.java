package Homeworks.happyFamily;

import java.util.ArrayList;

public class HappyFamily {
    public static void main(String[] args) {

        Pet pet = new Pet("Murzik", "cat", 10, 28);
        Pet pet2 = new Pet("Gold", "dog", 2, 87);
        Pet pet3 = new Pet("Bor", "cat", 8, 16);
        pet3.addHabit("Jump");
        Pet pet4 = new Pet("Adun", "monkey", 16, 99);
        pet4.addHabit("Run");

        System.out.println(pet3.toString());
        pet3.removeHabit("Jump");
        System.out.println(pet3.toString());

        Human human1 = new Human("John", "Johnson", 1999, 150);
        human1.addTaskToSchedule("Go to work!");
        Human human2 = new Human("Julia", "Wick", 2000, 135);
        Human human3 = new Human("Jimmy", "Johnson", 2024, 90);
        Human human4 = new Human("Jay", "Johnson", 2020, 100);

        Pet oldPet = new Pet("Babun", "monkey", 26, 19);
        Pet youngPet = new Pet("Babunchik", "monkey", 13, 78);

        Human oldMan = new Human("Jack", "Wick", 1950, 89);
        oldMan.addTaskToSchedule("Sleep");
        Human oldWoman = new Human("Jessica", "Wick", 1954, 109);
        Human man = new Human("Martin", "Wick", 2000, 113);
        Human woman = new Human("Marta", "Glek", 2001, 79);
        Human child = new Human("Jack", "Wick", 1950, 89);

        Family newFamily = new Family(woman, man);
        newFamily.addChild(child);
        newFamily.addChild(human2);
        newFamily.setFather(oldMan);
        newFamily.setMother(oldWoman);
        System.out.println(newFamily.toString());
        newFamily.removeChild(human2);
        System.out.println(newFamily.toString());

        System.out.println(oldWoman.getFamily().toString());
    }
}
