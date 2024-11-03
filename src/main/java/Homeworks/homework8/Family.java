package Homeworks.homework8;

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
    }

    public Human getFather() { return father; }
    public Human getMother() { return mother; }
    public Pet getPet() { return pet; }
    public ArrayList<Human> getChildren() { return children; }
    public void setFather(Human father) { this.father = father; this.father.setFamily(this); }
    public void setMother(Human mother) { this.mother = mother; this.mother.setFamily(this);}
    public void setPet(Pet pet) { this.pet = pet; }
    public void addChild(Human child) { this.children.add(child); child.setFamily(this);}
    public void removeChild(Human child) { this.children.remove(child);}
    public void removeChild(int index) { this.children.remove(index);}

    public Human getChild(int i) {
        return children.get(i);
    }

    public int countFamily(){
        return countOfMembers;
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
