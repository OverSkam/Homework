package Homeworks.happyFamily;

import java.util.ArrayList;

public class Pet {
    private String nickname;
    private String species;
    private int age;
    private int trickLevel;
    private ArrayList<String> habits = new ArrayList<>();

    public Pet(String nickname, String species, int age, int trickLevel) {
        this.nickname = nickname;
        this.species = species;
        this.age = age;
        this.trickLevel = trickLevel;
    }

    public Pet(String nickname, String species, int age, int trickLevel, ArrayList<String> habits) {
        this.nickname = nickname;
        this.species = species;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public void eat(){
        System.out.println("I'm eating");
    }
    public void respond(){
        System.out.printf("I'm %s", nickname);
        System.out.println();
    }
    public void foul(){
        System.out.println("I'm foul, you should clear");
    }

    @Override
    public String toString() {
        return "{nickname: %s, species: %s, age: %s, trickLevel: %s, habits: %s}".formatted(nickname, species, age, trickLevel, habits.toString());
    }

    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setSpecies(String species) { this.species = species; }
    public void setAge(int age) { this.age = age; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public void addHabit(String habit){ habits.add(habit); }
    public void removeHabit(String habit){ habits.remove(habit); }
    public String getNickname() { return nickname; }
    public String getSpecies() { return species;}
    public int getAge() { return age; }
    public int getTrickLevel() { return trickLevel; }
    public ArrayList<String> getHabits() { return habits;}

}
