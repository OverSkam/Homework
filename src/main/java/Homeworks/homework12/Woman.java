package Homeworks.homework12;

public final class Woman extends Human {
    public Woman(String name, String surname, long birthDate, int iq) {
        super(name, surname, birthDate, iq);
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
