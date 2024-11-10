package Homeworks.homework12;

public class HappyFamily {
    public static void main(String[] args) {

        FamilyService familyService = new FamilyService();
        Human h1 = new Human("1", "1", "1000/10/10", 10);
        Human h2 = new Human("2", "2", "1000/10/10", 20);
        familyService.createNewFamily(h1, h2);
        familyService.displayAllFamilies();
        familyService.displayAllFamilies1();
    }
}
