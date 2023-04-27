public class Main {

    public static void main(String[] args) {

//        Is inhertiance like a Car class. but taxi and limo are cars, but different a bit.
//        Might have base characteristics like has tyres and light. but limo might have aircon, etc. where not all cars do


        Animal animal = new Animal("Animal", 1, 1, 5, 5);

        Dog dog = new Dog("Yorkie", 8, 20, 2, 4, 1, 20, "long silky");
//        dog.eat();      // Can you method eat even though the method is in Animal Class. Feature of Inheritance. Can access all methods unless maybe private??? Not sure yet
        dog.walk();
//        dog.run();
        System.out.println(dog.getBody());

    }
}
