package Homeworks.happyFamily3;

public class Fish extends Pet {

    public Fish(String nickname, int age, int trickLevel){
        super(nickname, age, trickLevel);
        setSpecies(Species.Fish);
    }

    public Fish(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.Fish);
    }

    @Override
    public void respond() {
        System.out.println("Drop sound");
    }

}
