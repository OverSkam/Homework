package Homeworks.homework8;

public final class Man extends Human {
    public Man(String name, String surname, long yearOfBirth, int iq) {
        super(name, surname, yearOfBirth, iq);
    }
    public Man(String name, String surname, String stringDate, int iq) {
        super(name, surname, stringDate, iq);
    }


    @Override
    public void greetPet(){
        System.out.println("Hi my little pet");
    }

    public void playingComputer(){
        System.out.println("I am playing computer");
    }
}
