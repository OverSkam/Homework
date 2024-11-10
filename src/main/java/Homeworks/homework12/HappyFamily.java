package Homeworks.homework12;

public class HappyFamily {
    public static void main(String[] args) {

        FamilyController fc = new FamilyController();
        Human h1 = new Human("1", "1", "1000/10/10", 10);
        Human h2 = new Human("2", "2", "1000/10/10", 20);
        fc.createNewFamily(h1, h2);
        fc.createNewFamily(h2, h1);
        fc.adoptChild(0, h1);
        fc.displayAllFamilies();
        fc.getFamiliesBiggerThan(2);
        fc.getFamiliesLessThan(3);
        System.out.println(fc.countFamiliesWithMemberNumber(2));
        System.out.println(fc.count());
        fc.deleteFamilyByIndex(0);
        System.out.println(fc.count());
    }
}
