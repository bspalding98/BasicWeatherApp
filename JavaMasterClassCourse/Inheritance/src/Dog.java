public class Dog extends Animal {
//    fields or instance variables
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String coat;

//    constructor
    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String coat) {
//        From the Animal class constructor
        super(name, 1, 1, size, weight); // Like "this", calls from the constructor that this class extends from ie Animal. - Can also inhert methods
                                                    // Shrinking parameters by adding default values. ie we all know  a dog has a brain and body so can default 1 (true)
//        For Dog class.
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.coat = coat;
    }

//    Setter
    private void chew() {
        System.out.println("Dog.chew() called");
    }

    public void walk() {
        System.out.println("Dog.walk() called");
//        super.move(5);
        move(5); // This is better because if you override the move() from Animal class to update it. it will update, where super.move(10) won't
//        If there is no move(), it will just automatically executes the super.move()
    }

    public void run() {
        System.out.println("Dog.run() called");
        move(10);
//        super.move(10);
    }

    public void moveLegs(int speed) {
        System.out.println("Dog.moveLegs() called");
    }

//    Getter

//    Overrides
    @Override       // Reminding you that you are overriding a method in the Animal(super) class. Can be used to create a version of a method in the Animal class unique for Dog class
    public void eat() {
        System.out.println("Dog.eat() called");
        chew();
        super.eat();        // call the super equivalent of this current class. Animal eat() for this instance
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move() called");
        moveLegs(speed);
        super.move(speed);
    }
}
