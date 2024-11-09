package Homeworks.homework11;

import java.util.ArrayList;
import java.util.List;

public class Family {
    private Human father;
    private Human mother;
    private Pet pet;
    private ArrayList<Human> children = new ArrayList<>();
    private int countOfMembers = 2;

    public Family(Human mother, Human father) {
        this.father = father;
        this.mother = mother;
        this.father.setFamily(this);
        this.mother.setFamily(this);
        FamilyService.families.add(this);
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Pet getPet() {
        return pet;
    }

    public ArrayList<Human> getChildren() {
        return children;
    }

    public void setFather(Human father) {
        this.father = father;
        this.father.setFamily(this);
    }

    public void setMother(Human mother) {
        this.mother = mother;
        this.mother.setFamily(this);
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.setFamily(this);
        this.countOfMembers++;
    }

    public void removeChild(Human child) {
        this.children.remove(child);
        this.countOfMembers--;
    }

    public void removeChild(int index) {
        this.children.remove(index);
        this.countOfMembers--;
    }

    public void setChildren(ArrayList<Human> children) {
        this.children = children;
        this.countOfMembers = 2 + children.size();
    }

    public Human getChild(int i) {
        return children.get(i);
    }

    public int countMembers() {
        return countOfMembers;
    }

    public void deleteAllChildrenOlderThan(int x) {
        int size = this.children.size();
        int i = 0;
        long y = (long) x * 365 * 24 * 60 * 60 * 1000;
        long now = System.currentTimeMillis();
        while (i < size) {
            if (now - children.get(i).getYearOfBirth() < y) {
                this.children.remove(i);
                size--;
            } else
                i++;
        }
    }

    public String prettyFormat() {
        String out = "";
        out += "         mother: {name='%s', surname='%s', birthDate='%s', iq=%d, schedule="
                .formatted(mother.getName(), mother.getSurname(), mother.getStringDate(), mother.getIq());
        if (mother.getSchedule() != null)
            out += mother.getSchedule();
        out += "}\n";
        out += "         father: {name='%s', surname='%s', birthDate='%s', iq=%d, schedule="
                .formatted(father.getName(), father.getSurname(), father.getStringDate(), father.getIq());
        if (father.getSchedule() != null)
            out += father.getSchedule();
        out += "}\n";
        if (children.size() > 0)
            out += "         children:\n";
        for (Human child : children) {
            if (child instanceof Man)
                out += "                  boy: ";
            else
                out += "                  girl: ";
            out += "{name='%s', surname='%s', birthDate='%s', iq=%d, schedule="
                    .formatted(child.getName(), child.getSurname(), child.getStringDate(), child.getIq());
            if (child.getSchedule() != null)
                out += child.getSchedule();
            out += "}\n";
        }

        if (pet != null)
            out += "         pet: " + pet;

        return out;
    }

    public static ArrayList<Family> fromString(String input) {
        ArrayList<Family> ret = new ArrayList<>();
        String[] families = input.split("\\$");
        for (String family : families) {
            String[] people = family.split("\\{");
            ArrayList<Human> humans = new ArrayList<>();
            for (String person : people) {
                String[] p = person.split("\\|");
                humans.add(new Human(p[0], p[1], p[2], Integer.parseInt(p[3])));
            }
            Family f = new Family(humans.get(0), humans.get(1));
            int k = 0;
            for (Human child : humans) {
                if (k > 2)
                    f.addChild(child);
                k++;
            }
            ret.add(f);
        }
        return ret;
    }

    public String represent(){
        String result = "%s|%s|%s|%d{%s|%s|%s|%d"
                .formatted(mother.getName(), mother.getSurname(), mother.getStringDate(), mother.getIq(),
                        father.getName(), father.getSurname(), father.getStringDate(), father.getIq());
        for (Human child : children) {
            result += "{%s|%s|%s|%d".formatted(child.getName(), child.getSurname(), child.getStringDate(), child.getIq());
        }
        return result;
    }

    @Override
    public String toString() {
        String out = "";
        out += "         mother: {name='%s', surname='%s', birthDate='%s', iq=%d, schedule="
                .formatted(mother.getName(), mother.getSurname(), mother.getStringDate(), mother.getIq());
        if (mother.getSchedule() != null)
            out += mother.getSchedule();
        out += "}\n";
        out += "         father: {name='%s', surname='%s', birthDate='%s', iq=%d, schedule="
                .formatted(father.getName(), father.getSurname(), father.getStringDate(), father.getIq());
        if (father.getSchedule() != null)
            out += father.getSchedule();
        out += "}\n";
        if (children.size() > 0)
            out += "         children:\n";
        for (Human child : children) {
            if (child instanceof Man)
                out += "                  boy: ";
            else
                out += "                  girl: ";
            out += "{name='%s', surname='%s', birthDate='%s', iq=%d, schedule="
                    .formatted(child.getName(), child.getSurname(), child.getStringDate(), child.getIq());
            if (child.getSchedule() != null)
                out += child.getSchedule();
            out += "}\n";
        }

        if (pet != null)
            out += "         pet: " + pet;

        return out;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family that = (Family) o;
        if (!father.equals(that.father)) return false;
        if (!mother.equals(that.mother)) return false;
        return children.equals(that.children);
    }

}
