package Homeworks.homework9;

import java.util.ArrayList;

public class FamilyService {
    ArrayList<Family> families = new ArrayList<>();

    public void displayAllFamilies(){
        families.forEach(System.out::println);
    }

    public void getFamiliesBiggerThan(int x){
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
