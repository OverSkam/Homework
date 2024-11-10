package Homeworks.homework12;

import java.util.ArrayList;

public class DomesticCat extends Pet implements mb {

    public DomesticCat(String nickname, int age, int trickLevel){
        super(nickname, age, trickLevel);
        setSpecies(Species.Dog);
    }

    public DomesticCat(String nickname, int age, int trickLevel, ArrayList<String> habits){
        super(nickname, age, trickLevel, habits);
        setSpecies(Species.Dog);
    }

    @Override
    public void respond() {
        System.out.println("Meow");
    }

    @Override
    public void foul() {
        System.out.println("Fouled like cat");
    }
}
