package Homeworks.happyFamily;

import java.util.ArrayList;

public class Human {
    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq;
    private Human mother;
    private Human father;
    private Pet pet;
    private Family family;
    private ArrayList<String> schedule = new ArrayList<>();

    public Human(String name, String surname, int yearOfBirth, int iq) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
    }
    public Human(String name, String surname, int yearOfBirth, int iq, Human mother, Human father) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
        this.mother = mother;
        this.father = father;
    }

    public Human(String name, String surname, int yearOfBirth, int iq, Human mother, Human father, Pet pete) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
        this.mother = mother;
        this.father = father;
        this.pet = pet;
    }

    public Human(String name, String surname, int yearOfBirth, int iq, Pet pet) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
        this.pet = pet;
    }

    public Human() {
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public int getYearOfBirth() { return yearOfBirth; }
    public void setYearOfBirth(int yearOfBirth) { this.yearOfBirth = yearOfBirth; }
    public int getIq() { return iq; }
    public void setIq(int iq) { this.iq = iq; }
    public Human getMother() { return mother;}
    public void setMother(Human mother) { this.mother = mother; }
    public Human getFather() { return father; }
    public void setFather(Human father) { this.father = father; }
    public Pet getPets(){ return pet;}
    public void setPets(ArrayList<Pet> pets){ this.pet = pet;}
    public Family getFamily(){ return family;}
    public void setFamily(Family family) { this.family = family;}
    public ArrayList<String> getSchedule() { return schedule; }
    public void setSchedule(ArrayList<String> schedule) { this.schedule = schedule; }
    public void addTaskToSchedule(String task) { this.schedule.add(task); }
    public void removeTaskFromSchedule(String task) { this.schedule.remove(task); }


    public void greetPet(){
        System.out.printf("Greetings %s!\n", pet.getNickname());
    }

    public void describePet(){
        if (pet.getTrickLevel() > 50)
            System.out.printf("I have %s %s, he's %d and he's very tricky"
                    .formatted(pet.getSpecies(), pet.getNickname(), pet.getAge()));
        else
            System.out.printf("I have %s %s, he's %d and he's not tricky at all"
                    .formatted(pet.getSpecies(), pet.getNickname(), pet.getAge()));
        System.out.println();
    }

    @Override
    public String toString() {
        if (mother != null && father != null)
            if (pet != null)
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, mother: %s %s, father: %s %s, pet: %s, schedule: %s"
                    .formatted(name, surname, yearOfBirth, iq, mother.name, mother.surname, father.name, father.surname, pet.toString(), schedule.toString());
            else
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, mother: %s %s, father: %s %s, schedule: %s"
                        .formatted(name, surname, yearOfBirth, iq, mother.name, mother.surname, father.name, father.surname, schedule.toString());
        else
            if (pet != null)
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, pet: %s, schedule: %s"
                        .formatted(name, surname, yearOfBirth, iq, pet.toString(), schedule.toString());
            else
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, schedule: %s"
                        .formatted(name, surname, yearOfBirth, iq, schedule.toString());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Human)) return false;
        Human that = (Human) o;
        if (this.yearOfBirth != that.yearOfBirth) return false;
        if (this.iq != that.iq) return false;
        if (!this.mother.equals(that.mother)) return false;
        if (!this.father.equals(that.father)) return false;
        return true;
    }


}
