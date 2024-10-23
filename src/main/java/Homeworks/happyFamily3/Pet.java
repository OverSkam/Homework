package Homeworks.happyFamily3;

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
    private String[] habits = new String[0];

    public Pet(String nickname, int age, int trickLevel) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.species = Species.Uknown;
    }

    public Pet(String nickname, int age, int trickLevel, String[] habits) {
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
    public void addHabit(String habit){ habits = addHabitPrivate(habit); }
    public void removeHabit(String habit){ habits = removeHabitPrivate(habit); }
    public String getNickname() { return nickname; }
    public int getAge() { return age; }
    public Species getSpecies() { return species;}
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
        if (habits.length > 0) {
            out += ", habits:";
            for (String habit : habits)
                out += " %s".formatted(habit);
        }
        out += " }";

        return out;
    }

}
