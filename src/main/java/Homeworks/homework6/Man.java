package Homeworks.homework6;

public class Man extends Human{
    public Man(String name, String surname, int yearOfBirth, int iq) {
        super(name, surname, yearOfBirth, iq);
    }

    @Override
    public void greetPet(){
        System.out.println("Hi my little pet");
    }

    public void playingComputer(){
        System.out.println("I am playing computer");
    }
}
