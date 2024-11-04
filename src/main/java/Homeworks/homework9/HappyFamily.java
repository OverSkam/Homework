package Homeworks.homework9;

public class HappyFamily {
    public static void main(String[] args) {

        Woman human1 = new Woman("J", "G", 1730656394221L, 100);
        Man human2 = new Man("J1", "G1", "2005/10/10", 100);
        Man child = new Man("j", "g", "2010/10/10", 100);
        Family family = new Family(human1, human2);
        family.addChild(child);
        family.addChild(human2);

        FamilyService tracker = new FamilyService();
        tracker.families.add(family);
        tracker.displayAllFamilies();
        System.out.println(tracker.countFamiliesWithMemberNumber(3));
        family.deleteAllChildrenOlderThan(16);
        System.out.println(family.toString());
    }
}
