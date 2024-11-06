package Homeworks.homework10;

import java.util.ArrayList;

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

    public Human getFather() { return father; }
    public Human getMother() { return mother; }
    public Pet getPet() { return pet; }
    public ArrayList<Human> getChildren() { return children; }
    public void setFather(Human father) { this.father = father; this.father.setFamily(this); }
    public void setMother(Human mother) { this.mother = mother; this.mother.setFamily(this);}
    public void setPet(Pet pet) { this.pet = pet; }
    public void addChild(Human child) { this.children.add(child); child.setFamily(this); this.countOfMembers++; }
    public void removeChild(Human child) { this.children.remove(child); this.countOfMembers--;}
    public void removeChild(int index) { this.children.remove(index); this.countOfMembers--;}
    public void setChildren(ArrayList<Human> children) { this.children = children; this.countOfMembers = 2 + children.size(); }

    public Human getChild(int i) {
        return children.get(i);
    }

    public int countMembers(){
        return countOfMembers;
    }

    public void deleteAllChildrenOlderThan(int x){
        System.out.println(this.children.size());

        int size = this.children.size();
        int i = 0;
        long y = (long) x * 365 * 24 * 60 * 60 * 1000;
        long now = System.currentTimeMillis();
        while(i < size) {
            if (now - children.get(i).getYearOfBirth() < y) {
                this.children.remove(i);
                size--;
            }
            else
                i++;
        }
    }

    public String prettyFormat(){
        String out  = "";
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
            out += "         pet: " + pet.toString();

        return out;
    }

    @Override
    public String toString() {
        if (countOfMembers == 2)
            return "Family: mother: '%s %s', father: '%s %s'"
                    .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname());
        else {
            String out = "Family: mother: '%s %s', father: '%s %s', children:"
                    .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname());
            for (Human child : children)
                out += " '%s'".formatted(child.getName());

            if (pet != null)
                out += " pet: %s ".formatted(pet.toString());

            return out;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Family that = (Family) o;
        if (!father.equals(that.father)) return false;
        if (!mother.equals(that.mother)) return false;
        if (!children.equals(that.children)) return false;
        return true;
    }

}
