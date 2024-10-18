package Homeworks.happyFamily;

public class HappyFamily {
    public static void main(String[] args) {
        Pet pet = new Pet("Goidick", "Cat", 10, 56);
        System.out.println(pet.toString());
        pet.addHabit("Jumping onto the table");
        pet.addHabit("Jumping onto the table");
        pet.addHabit("Jumping onto the table");
        System.out.println(pet.toString());
    }
}
