package Homeworks.happyFamily3;

public class Dog extends Pet implements mb{

    public Dog(String nickname, int age, int trickLevel){
        super(nickname, age, trickLevel);
        setSpecies(Species.Dog);
    }

    public Dog(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.Dog);
    }

    @Override
    public void respond() {
        System.out.println("Gav");
    }

    @Override
    public void foul() {
        System.out.println("Foul foul foul");
    }
}
