package Homeworks.homework6;

public class RoboCat extends Pet implements mb{

    public RoboCat(String nickname, int age, int trickLevel){
        super(nickname, age, trickLevel);
        setSpecies(Species.RoboCat);
    }

    public RoboCat(String nickname, int age, int trickLevel, String[] habits){
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.RoboCat);
    }

    @Override
    public void respond() {
        System.out.println("Robo-meow");
    }

    @Override
    public void foul() {
        System.out.println("Robo-foul");
    }
}
