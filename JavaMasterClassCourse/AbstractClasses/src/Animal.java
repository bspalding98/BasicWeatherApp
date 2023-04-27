public abstract class Animal {      // abstract is now forcing them to use these methods.
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breathe(); // All animals breathe so why not make it interface? Because fish would implement breathe() differently to a dog. Many parameters, etc.

    public String getName() {
        return name;
    }
}
