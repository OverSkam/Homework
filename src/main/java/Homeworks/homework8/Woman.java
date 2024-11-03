package Homeworks.homework8;

public final class Woman extends Human {
    public Woman(String name, String surname, long yearOfBirth, int iq) {
        super(name, surname, yearOfBirth, iq);
    }
    public Woman(String name, String surname, String stringDate, int iq) {
        super(name, surname, stringDate, iq);
    }


    @Override
    public void greetPet(){
        System.out.println("Hello my loved pet");
    }

    public void cooking(){
        System.out.println("I am playing cooking");
    }
}
