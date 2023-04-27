public class Main {
    // Difference between interface and abstract
    // BIRD and DOG IS A animal so makes sense to inherit from an animal class
    // PARROT IS A BIRD so you would inherit from a BIRD class.
        // BATS also fly so why no change BIRD class to FLYING class so he can inherit
        // Because then bats give birth to young, not lay eggs and not all birds can fly. So it makes it have issues later on.
    // So instead of BIRD class for just fly(). Change it to an interface called CanFly()

    // ABSTRACT CLASS can have member variables that can be implemented
    // INTERFACE can have variables. but would be all public static final variables which would never change.
        // Have to be static because non static variables require an instance. Cant instantiate an interface
        // Also cannot have constructors
    // ABSTRACT can
    // interface methods are all auto public.
        //ABSTRACT class can be private or public.
    // ABSTRACT can have defined names like getName();
    // INTERFACE all is abstract so everything needs to be implemented what is written.

    public static void main(String[] args) {

        Dog dog = new Dog("Yorkie");
        dog.breathe();
        dog.eat();

        // No need to change this because Bird class is no abstract
//        Bird bird = new Bird("Parrot");
//        bird.breathe();
//        bird.eat();

        Parrot parrot = new Parrot("Australia ringneck");
        parrot.breathe();
        parrot.eat();
        parrot.fly();

        Penguin penguin = new Penguin("Emperor");
        penguin.fly();
    }
}
