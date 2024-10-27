package Homeworks.homework7;

import java.util.HashMap;
import java.util.Map;

enum Days{

    Sunday,
    Monady,
    Tuesday,
    Wednesday,
    Thursday,
    Friday,
    Saturday

}

public class Human {
    private String name;
    private String surname;
    private int yearOfBirth;
    private int iq;
    private Family family;
    private Map<Days, String> schedule = new HashMap<>();

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


    public void addTaskToSchedule(Days day, String task) {
        schedule.put(day, task);
    }

    public void removeTaskFromSchedule(Days day) {
        schedule.remove(day);
    }

    public void removeTaskFromSchedule(String task) {
        schedule.values().remove(task);
    }

    public String getSchedule(Days day) {
        return schedule.get(day);
    }

    public void greetPet(){
        System.out.printf("Greetings %s!\n", family.getPet().getNickname());
    }

    public void describePet(){
        if (family.getPet().getTrickLevel() > 50)
            System.out.printf("I have %s %s, he's %d and he's very tricky"
                    .formatted(family.getPet(), family.getPet().getNickname(), family.getPet().getAge()));
        else
            System.out.printf("I have %s %s, he's %d and he's not tricky at all"
                    .formatted(family.getPet().getSpecies(), family.getPet().getNickname(), family.getPet().getAge()));
        System.out.println();
    }

    @Override
    public String toString() {
        if (family != null) {
            if (family.getMother() != null && family.getFather() != null) {
                if (family.getPet() != null)
                    return "name: '%s', surname: '%s', year of birth: %d, iq: %d, mother: %s %s, father: %s %s, pet: %s"
                            .formatted(name, surname, yearOfBirth, iq, family.getMother().getName(), family.getMother().getSurname(), family.getFather().getName(), family.getFather().getSurname(), family.getPet().toString());
                else
                    return "name: '%s', surname: '%s', year of birth: %d, iq: %d, mother: %s %s, father: %s %s"
                            .formatted(name, surname, yearOfBirth, iq, family.getMother().getName(), family.getMother().getSurname(), family.getFather().getName(), family.getFather().getSurname());
            }
            else {
                if (family.getPet() != null)
                    return "name: '%s', surname: '%s', year of birth: %d, iq: %d, pet: %s"
                            .formatted(name, surname, yearOfBirth, iq, family.getPet().toString());
            }
            return "name: '%s', surname: '%s', year of birth: %d, iq: %d"
                    .formatted(name, surname, yearOfBirth, iq);
        }
        else
            return "name: '%s', surname: '%s', year of birth: %d, iq: %d"
                    .formatted(name, surname, yearOfBirth, iq);
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
