package Homeworks.homework7;

public final class Woman extends Human {
    public Woman(String name, String surname, int yearOfBirth, int iq) {
        super(name, surname, yearOfBirth, iq);
    }

    @Override
    public void greetPet(){
        System.out.println("Hello my loved pet");
    }

    public void cooking(){
        System.out.println("I am playing cooking");
    }
}
