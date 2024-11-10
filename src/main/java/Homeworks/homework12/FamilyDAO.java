package Homeworks.homework12;

import java.util.ArrayList;
import java.util.List;

public interface FamilyDAO {
    public ArrayList<Family> getAllFamilies();
    public Family getFamily(int id);
    public void deleteFamily(int id);
    public void deleteFamily(Family family);
    public void saveFamily(Family family);

}
