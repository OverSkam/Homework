package Homeworks.homework12;

import java.util.ArrayList;
import java.util.List;

public class CollectionFamilyDAO implements FamilyDAO{

    static ArrayList<Family> families = new ArrayList<Family>();

    @Override
    public ArrayList<Family> getAllFamilies() {
        return families;
    }

    @Override
    public Family getFamily(int id) {
        return families.get(id);
    }

    @Override
    public void deleteFamily(int id) {
        families.remove(id);
    }

    @Override
    public void deleteFamily(Family family) {
        families.remove(family);
    }

    @Override
    public void saveFamily(Family family) {
        families.add(family);
    }
}
