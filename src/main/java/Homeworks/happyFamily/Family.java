package Homeworks.happyFamily;

import java.util.ArrayList;

public class Family {
    private Human father;
    private Human mother;
    private ArrayList<Human> children = new ArrayList<Human>();
    private int countOfMembers = 2;

    public Family(Human mother, Human father) {
        this.father = father;
        this.mother = mother;
    }

    public Human getFather() { return father; }
    public Human getMother() { return mother; }
    public ArrayList<Human> getChildren() { return children; }
    public void setFather(Human father) { this.father = father; }
    public void setMother(Human mother) { this.mother = mother; }
    public void setChildren(ArrayList<Human> children) { this.children = children; countOfMembers = 2 + children.size(); }

    public void addChild(Human child) {
        children.add(child);
        countOfMembers++;
        child.setMother(mother);
        child.setFather(father);
        child.setFamily(this);
    }

    public Human getChild(int i) {
        return children.get(i);
    }

    public void removeChild(Human child) {
        children.remove(child);
        countOfMembers--;
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

            return out;
        }
    }

}
