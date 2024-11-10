package Homeworks.homework12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FamilyService {
    private final FamilyDAO data = new CollectionFamilyDAO();
    private final ArrayList<Family> families = data.getAllFamilies();

    Random rand = new Random();

    public ArrayList<Family> getAllFamilies() {
        return families;
    }

    public void displayAllFamilies() {
        int familyIndex = 1;
        for (Family family : families) {
            System.out.printf("Family #%d", familyIndex);
            System.out.println();
            System.out.println(family.prettyFormat());
            familyIndex++;
        }
    }

//    public void displayAllFamilies1(){
//        int familyIndex = 1;
//        for (Family family : CollectionFamilyDAO.families) {
//            System.out.printf("Family #%d", familyIndex);
//            System.out.println();
//            System.out.println(family.prettyFormat());
//            familyIndex++;
//        }
//    }

    public void getFamiliesBiggerThan(int x) {
        families.stream()
                .filter(k -> k.countMembers() > x)
                .forEach(System.out::println);
    }

    public void getFamiliesLessThan(int x) {
        families.stream()
                .filter(k -> k.countMembers() < x)
                .forEach(System.out::println);
    }

    public long countFamiliesWithMemberNumber(int x) {
        return families.stream()
                .filter(k -> k.countMembers() == x)
                .count();
    }

    public void createNewFamily(Human mother, Human father) {
        families.add(new Family(mother, father));
    }

    public void deleteFamily(Family family) {
        families.remove(family);
    }

    public void deleteFamilyByIndex(int index) {
        families.remove(index);
    }

    public void bronChild(int index, String nameBoy, String nameGirl) {
        String name;
        name = rand.nextInt(2) + 1 == 1 ? nameBoy : nameGirl;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String birthDate = LocalDate.now().format(formatter);
        families.get(index).addChild(new Human(name, families.get(index).getFather().getSurname(), birthDate, rand.nextInt(150) + 70));
    }

    public void adoptChild(int index, Human human) {
        families.get(index).addChild(human);
    }

    public void deleteAllChildrenOlderThan(int age) {
        for (Family family : families)
            family.deleteAllChildrenOlderThan(age);
    }

    public int count(){
        return families.size();
    }

    public Family getFamily(int index){
        return families.get(index);
    }

}
