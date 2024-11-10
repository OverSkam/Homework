package Homeworks.homework12;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

public class FamilyController {
    FamilyService fs = new FamilyService();
    Random rand = new Random();

    public ArrayList<Family> getAllFamilies() {
        return fs.getAllFamilies();
    }

    public void displayAllFamilies() {
        int familyIndex = 1;
        for (Family family : fs.getAllFamilies()) {
            System.out.printf("Family #%d", familyIndex);
            System.out.println();
            System.out.println(family.prettyFormat());
            familyIndex++;
        }
    }

    public void getFamiliesBiggerThan(int x) {
        fs.getAllFamilies().stream()
                .filter(k -> k.countMembers() > x)
                .forEach(System.out::println);
    }

    public void getFamiliesLessThan(int x) {
        fs.getAllFamilies().stream()
                .filter(k -> k.countMembers() < x)
                .forEach(System.out::println);
    }

    public long countFamiliesWithMemberNumber(int x) {
        return fs.getAllFamilies().stream()
                .filter(k -> k.countMembers() == x)
                .count();
    }

    public void createNewFamily(Human mother, Human father) {
        fs.getAllFamilies().add(new Family(mother, father));
    }

    public void deleteFamily(Family family) {
        fs.getAllFamilies().remove(family);
    }

    public void deleteFamilyByIndex(int index) {
        fs.getAllFamilies().remove(index);
    }

    public void bronChild(int index, String nameBoy, String nameGirl) {
        String name;
        name = rand.nextInt(2) + 1 == 1 ? nameBoy : nameGirl;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String birthDate = LocalDate.now().format(formatter);
        fs.getAllFamilies().get(index).addChild(new Human(name, fs.getAllFamilies().get(index).getFather().getSurname(), birthDate, rand.nextInt(150) + 70));
    }

    public void adoptChild(int index, Human human) {
        fs.getAllFamilies().get(index).addChild(human);
    }

    public void deleteAllChildrenOlderThan(int age) {
        for (Family family : fs.getAllFamilies())
            family.deleteAllChildrenOlderThan(age);
    }

    public int count(){
        return fs.getAllFamilies().size();
    }

    public Family getFamily(int index){
        return fs.getAllFamilies().get(index);
    }

}
