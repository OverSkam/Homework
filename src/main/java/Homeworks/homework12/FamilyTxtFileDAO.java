package Homeworks.homework12;

import java.io.*;
import java.util.ArrayList;

public class FamilyTxtFileDAO {

    public ArrayList<Family> loadAll() throws IOException {
        try (BufferedReader r = new BufferedReader(new FileReader(new File("family.txt")))) {
            String line = "";
            for (String l = r.readLine(); l != null; l = r.readLine())
                line += l;
            return Family.fromString(line);
        }
    }

    public void save(ArrayList<Family> families) throws IOException {
        try (BufferedWriter w = new BufferedWriter(new FileWriter(new File("family.txt")))) {
            int k = 0;
            for (Family f : families) {
                if (k == 0) {
                    w.write(f.represent());
                } else {
                    w.write("$" + f.represent());
                }
                w.newLine();
                k++;
            }
        }
    }
}
