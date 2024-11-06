package Homeworks.homework10;

import java.util.ArrayList;

public class FamilyService {
    static ArrayList<Family> families = new ArrayList<>();

    public void displayAllFamilies(){
        int familyIndex = 1;
        for (Family family : families) {
            System.out.printf("Family #%d", familyIndex);
            System.out.println();
            System.out.println(family.prettyFormat());
            familyIndex++;
        }
    }

    public void getFamiliesMoreThan(int x){
        families.stream()
                .filter(k -> k.countMembers() > x)
                .forEach(System.out::println);
    }

    public void getFamiliesLessThan(int x){
        families.stream()
                .filter(k -> k.countMembers() < x)
                .forEach(System.out::println);
    }

    public long countFamiliesWithMemberNumber(int x){
        return families.stream()
                .filter(k -> k.countMembers() == x)
                .count();
    }

    public ArrayList<Family> getFamilies() {
        return families;
    }
}
