package Homeworks.homework12;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
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
    private long birthDate;
    private final String stringDate;
    private int iq;
    private Family family;
    private final Map<Days, String> schedule = new HashMap<>();

    public Human(String name, String surname, long birthDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.iq = iq;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date(birthDate);
        this.stringDate = sdf.format(date);
    }

    public Human(String name, String surname, String stringDate, int iq) {
        this.name = name;
        this.surname = surname;
        this.stringDate = stringDate;
        this.iq = iq;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date date = null;
        try {
            date = sdf.parse(stringDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        this.birthDate = date.getTime();
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurname() { return surname; }
    public void setSurname(String surname) { this.surname = surname; }
    public long getYearOfBirth() { return birthDate; }
    public void setYearOfBirth(long birthDate) { this.birthDate = birthDate; }
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
    public Map<Days, String> getSchedule() { return this.schedule; }
    public String getStringDate(){ return this.stringDate; }

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

    public void describeAge(){
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(birthDate);
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        LocalDate now = LocalDate.now();
        LocalDate birthDate = LocalDate.of(year, month, day);
        Period period = Period.between(birthDate, now);
        String s = "Years: %d, Months: %d, Days: %d"
                .formatted(period.getYears(), period.getMonths(), period.getDays());
    }

    @Override
    public String toString() {
        if (family != null) {
            if (family.getMother() != null && family.getFather() != null) {
                if (family.getPet() != null)
                    return "name: '%s', surname: '%s', year of birth: %s, iq: %d, mother: %s %s, father: %s %s, pet: %s"
                            .formatted(name, surname, stringDate, iq, family.getMother().getName(), family.getMother().getSurname(), family.getFather().getName(), family.getFather().getSurname(), family.getPet().toString());
                else
                    return "name: '%s', surname: '%s', year of birth: %s, iq: %d, mother: %s %s, father: %s %s"
                            .formatted(name, surname, stringDate, iq, family.getMother().getName(), family.getMother().getSurname(), family.getFather().getName(), family.getFather().getSurname());
            }
            else {
                if (family.getPet() != null)
                    return "name: '%s', surname: '%s', year of birth: %s, iq: %d, pet: %s"
                            .formatted(name, surname, stringDate, iq, family.getPet().toString());
            }
            return "name: '%s', surname: '%s', year of birth: %s, iq: %d"
                    .formatted(name, surname, stringDate, iq);
        }
        else
            return "name: '%s', surname: '%s', year of birth: %s, iq: %d"
                    .formatted(name, surname, stringDate, iq);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof Human that)) return false;
        if (this.birthDate != that.birthDate) return false;
        if (this.iq != that.iq) return false;
        if (!this.family.getMother().equals(that.family.getMother())) return false;
        return this.family.getFather().equals(that.family.getFather());
    }


}
