package Homeworks.homework9;

import java.util.ArrayList;

enum Species{
    Dog,
    DomesticCat,
    Fish,
    RoboCat,
    Uknown
}

interface mb{
    public abstract void foul();
}

abstract class Pet {
    private String nickname;
    private int age;
    private int trickLevel;
    private Species species;
    private ArrayList<String> habits = new ArrayList<>();

    public Pet(String nickname, int age, int trickLevel) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.species = Species.Uknown;
    }

    public Pet(String nickname, int age, int trickLevel, ArrayList<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
        this.species = Species.Uknown;
    }

    public Pet(){}

    public void eat(){
        System.out.println("I'm eating");
    }
    public abstract void respond();


    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setAge(int age) { this.age = age; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public void setSpecies(Species species) { this.species = species; }
    public void addHabit(String habit){ this.habits.add(habit); }
    public void removeHabit(String habit){ this.habits.remove(habit); }
    public String getNickname() { return nickname; }
    public int getAge() { return age; }
    public Species getSpecies() { return species;}
    public int getTrickLevel() { return trickLevel; }
    public ArrayList<String> getHabits() { return habits;}


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Pet that = (Pet) o;
        if (!this.nickname.equals(that.nickname)) return false;
        if (this.age != that.age) return false;
        if (this.trickLevel != that.trickLevel) return false;
        return true;
    }

    @Override
    public String toString() {
        String out = "{nickname: '%s', age: %s, trickLevel: %s"
                .formatted(nickname, age, trickLevel);
        if (!habits.isEmpty()) {
            out += ", habits:";
            for (String habit : habits)
                out += " %s".formatted(habit);
        }
        out += " }";

        return out;
    }

}
