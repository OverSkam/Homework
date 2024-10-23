package Homeworks.happyFamily;

import java.util.ArrayList;

public class Family {
    private Human father;
    private Human mother;
    private Pet pet;
    private Human[] children = new Human[0];
    private int countOfMembers = 2;

    public Family(Human mother, Human father) {
        this.father = father;
        this.mother = mother;
    }

    public Human getFather() { return father; }
    public Human getMother() { return mother; }
    public Pet getPet() { return pet; }
    public Human[] getChildren() { return children; }
    public void setFather(Human father) { this.father = father; this.father.setFamily(this); }
    public void setMother(Human mother) { this.mother = mother; this.mother.setFamily(this);}
    public void setPet(Pet pet) { this.pet = pet; }
    public void addChild(Human child) { children = addChildPrivate(child); child.setFamily(this);}
    public void removeChild(Human child) { children = removeChildPrivate(child);}

    private Human[] addChildPrivate(Human child) {
        int newLength = this.children.length;
        Human[] newChildren = new Human[newLength + 1];
        for (int i = 0; i < newLength; i++)
            newChildren[i] = this.children[i];
        newChildren[newLength] = child;
        countOfMembers++;
        return newChildren;
    }

    public Human getChild(int i) {
        return children[i];
    }

    private Human[] removeChildPrivate(Human child) {
        int newLength = this.children.length;
        Human[] newChildren = new Human[newLength - 1];
        for (int i = 0; i < newLength; i++) {
            if (child.equals(this.children[i]))
                continue;
            else
                newChildren[i] = this.children[i];
        }
            countOfMembers--;
        return newChildren;
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
            String out = "Family: mother: '%s %s', father: '%s %s', children: "
                    .formatted(mother.getName(), mother.getSurname(), father.getName(), father.getSurname());
            for (Human child : children)
                out += "'%s' ".formatted(child.getName());

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