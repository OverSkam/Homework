package Homeworks.homework9;

import Homeworks.homework9.FamilyService;

import java.sql.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;

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
