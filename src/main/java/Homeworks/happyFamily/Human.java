package Homeworks.happyFamily;

import java.util.ArrayList;

public class Human {
    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq;
    private Family family;
    private String[] schedule = new String[0];

    public Human(String name, String surname, int yearOfBirth, int iq) {
        this.name = name;
        this.surname = surname;
        this.yearOfBirth = yearOfBirth;
        this.iq = iq;
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
    public Human getMother() { return family.getMother();}
    public void setMother(Human mother) { this.family.setMother(mother); }
    public Human getFather() { return family.getFather(); }
    public void setFather(Human father) { this.family.setFather(father); }
    public Pet getPet(){ return family.getPet(); }
    public void setPet(Pet pet){ this.family.setPet(pet);}
    public Family getFamily(){ return family;}
    public void setFamily(Family family) { this.family = family;}
    public String[] getSchedule() { return schedule; }
    public void setSchedule(String[] schedule) { this.schedule = schedule; }
    public void addTaskToSchedule(String task) { this.schedule = addTask(task); }
    public void removeTaskFromSchedule(String task) { this.schedule = removeTask(task); }


    public String[] addTask(String task){
        int newLength = this.schedule.length;
        String[] newSchedule = new String[newLength + 1];
        for (int i = 0; i < newLength; i++)
            newSchedule[i] = this.schedule[i];
        newSchedule[newLength] = task;
        return newSchedule;
    }

    public String[] removeTask(String task){
        int newLength = this.schedule.length;
        String[] newSchedule = new String[newLength - 1];
        for (int i = 0; i < newLength; i++)
            if (task.equals(this.schedule[i]))
                continue;
            else
                newSchedule[i] = this.schedule[i];
        return newSchedule;
    }

    public void greetPet(){
        System.out.printf("Greetings %s!\n", family.getPet().getNickname());
    }

    public void describePet(){
        if (family.getPet().getTrickLevel() > 50)
            System.out.printf("I have %s %s, he's %d and he's very tricky"
                    .formatted(family.getPet().getSpecies(), family.getPet().getNickname(), family.getPet().getAge()));
        else
            System.out.printf("I have %s %s, he's %d and he's not tricky at all"
                    .formatted(family.getPet().getSpecies(), family.getPet().getNickname(), family.getPet().getAge()));
        System.out.println();
    }

    @Override
    public String toString() {
        if (family.getMother() != null && family.getFather() != null)
            if (family.getPet() != null)
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, mother: %s %s, father: %s %s, pet: %s, schedule: %s"
                    .formatted(name, surname, yearOfBirth, iq, family.getMother().getName(), family.getMother().getSurname(), family.getFather().getName(), family.getFather().getSurname(), family.getPet().toString(), schedule.toString());
            else
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, mother: %s %s, father: %s %s, schedule: %s"
                        .formatted(name, surname, yearOfBirth, iq, family.getMother().getName(), family.getMother().getSurname(), family.getFather().getName(), family.getFather().getSurname(), schedule.toString());
        else
            if (family.getPet() != null)
                return "name: '%s', surname: '%s', year of birth: %d, iq: %d, pet: %s, schedule: %s"
                        .formatted(name, surname, yearOfBirth, iq, family.getPet().toString(), schedule.toString());
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
        if (!this.family.getMother().equals(that.family.getMother())) return false;
        if (!this.family.getFather().equals(that.family.getFather())) return false;
        return true;
    }


}
