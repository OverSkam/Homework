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

        Human human1 = new Human("John", "Johnson", 1999, 150, pet3);
        human1.addTaskToSchedule("Go to work!");
        Human human2 = new Human("Julia", "Wick", 2000, 135);
        Human human3 = new Human("Jimmy", "Johnson", 2024, 90, human2, human1, pet);
        Human human4 = new Human("Jay", "Johnson", 2020, 100, human2, human1, pet4);

        Family family = new Family(human1, human2);
        family.addChild(human3);
        family.addChild(human4);
        //getting first child and showing info about his family
        System.out.println(family.getChild(0).getFamily().toString());
        //showing info about family
        System.out.println(family.toString());
        //info about father
        System.out.println(family.getFather().toString());

        Pet oldPet = new Pet("Babun", "monkey", 26, 19);
        Pet youngPet = new Pet("Babunchik", "monkey", 13, 78);

        Human oldMan = new Human("Jack", "Wick", 1950, 89, oldPet);
        oldMan.addTaskToSchedule("Sleep");
        Human oldWoman = new Human("Jessica", "Wick", 1954, 109, oldPet);
        Human man = new Human("Martin", "Wick", 2000, 113, oldWoman, oldMan, youngPet);
        Human woman = new Human("Marta", "Glek", 2001, 79);
        Human child = new Human("Jack", "Wick", 1950, 89, oldPet);

        Family newFamily = new Family(woman, man);
        newFamily.addChild(child);
        //showing that child didn't have parents but when he got into a family he got them
        System.out.println(newFamily.getChild(0).getFather().toString());

        System.out.println(oldMan.getPet().equals(man.getPet()));
    }
}
