package Homeworks.happyFamily3;

public class HappyFamily {
    public static void main(String[] args) {

        RoboCat cat = new RoboCat("1", 10, 10);
        cat.foul();
        cat.respond();
        cat.eat();
        Fish fish = new Fish("2", 10, 10);
        System.out.println(cat.toString());
        cat.addHabit("running");
        System.out.println(cat.toString());
        System.out.println(cat.getNickname());
        System.out.println("----------------------------------------");

        Man human1 = new Man("John", "Johnson", 1999, 150);
        Woman human2 = new Woman("Julia", "Wick", 2000, 135);
        Man human3 = new Man("Jimmy", "Johnson", 2024, 90);
        Man human4 = new Man("Jay", "Johnson", 2020, 100);

        Man oldMan = new Man("Jack", "Wick", 1950, 89);
        Woman oldWoman = new Woman("Jessica", "Wick", 1954, 109);
        Man man = new Man("Martin", "Wick", 2000, 113);
        Woman woman = new Woman("Marta", "Glek", 2001, 79);
        Man child = new Man("Jack", "Wick", 1950, 89);

        Dog dog = new Dog("1", 1 ,1);

        Family newFamily = new Family(woman, man);
        newFamily.setPet(dog);

        man.playingComputer();
        woman.cooking();

        System.out.println(dog.getSpecies());

        System.out.println(newFamily.getFather().getPet().getSpecies());

    }
}
