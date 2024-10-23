package Homeworks.happyFamily2;

enum Species{

    dog,
    cat,
    monkey,
    donkey
}

public class Pet {
    private String nickname;
    private Species species;
    private int age;
    private int trickLevel;
    private String[] habits = new String[0];

    public Pet(String nickname, String species, int age, int trickLevel) {
        this.nickname = nickname;
        this.species = Species.valueOf(species.toLowerCase());
        this.age = age;
        this.trickLevel = trickLevel;
    }

    public Pet(String nickname, String species, int age, int trickLevel, String[] habits) {
        this.nickname = nickname;
        this.species = Species.valueOf(species.toLowerCase());
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    public Pet(){}

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Pet that = (Pet) o;
        if (!this.nickname.equals(that.nickname)) return false;
        if (!this.species.equals(that.species)) return false;
        if (this.age != that.age) return false;
        if (this.trickLevel != that.trickLevel) return false;
        return true;
    }

    @Override
    public String toString() {
        String out = "%s {nickname: '%s', age: %s, trickLevel: %s"
                .formatted(species, nickname, age, trickLevel);
        if (habits.length > 0) {
            out += ", habits:";
            for (String habit : habits)
                out += " %s".formatted(habit);
        }
        out += " }";

        return out;
    }

    public void setNickname(String nickname) { this.nickname = nickname; }
    public void setSpecies(String species) { this.species = Species.valueOf(species.toLowerCase()); }
    public void setAge(int age) { this.age = age; }
    public void setTrickLevel(int trickLevel) { this.trickLevel = trickLevel; }
    public void addHabit(String habit){ habits = addHabitPrivate(habit); }
    public void removeHabit(String habit){ habits = removeHabitPrivate(habit); }
    public String getNickname() { return nickname; }
    public Species getSpecies() { return species;}
    public int getAge() { return age; }
    public int getTrickLevel() { return trickLevel; }
    public String[] getHabits() { return habits;}

    private String[] addHabitPrivate(String habit){
        int newLength = this.habits.length;
        String[] newSchedule = new String[newLength + 1];
        for (int i = 0; i < newLength; i++)
            newSchedule[i] = this.habits[i];
        newSchedule[newLength] = habit;
        return newSchedule;
    }

    private String[] removeHabitPrivate(String task){
        int newLength = this.habits.length;
        String[] newSchedule = new String[newLength - 1];
        for (int i = 0; i < newLength; i++)
            if (task.equals(this.habits[i]))
                continue;
            else
                newSchedule[i] = this.habits[i];
        return newSchedule;
    }

}
