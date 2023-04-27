public class BedRoom {
//    fields or instance variables or member variables
    private Lamp lamp;
    private Bed bed;
    private Window window;

    public BedRoom() {
        this(new Lamp(0, 0, false), new Bed("Unknown", 0, 0),
                new Window(0, 0, 0));
//        this.lamp = new Lamp(0, 0, false);
//        this.bed = new Bed("King", 4, 1);
    }
    public BedRoom(Lamp lamp, Bed bed, Window window) {
        this.lamp = lamp;
        this.bed = bed;
        this.window = window;
    }

//    getters
    public void isLampOn(boolean state) {   // Could have two class one called turnLampOn, and another turnLampOff. Which just passes in a set state or true or false instead of having to write it in main
        lamp.isLampOn(state);
    }

    public void getBedSize() {
        bed.getSize();
    }

    public Window getWindows() {
        return window;
    }

    public Bed getBed() {
        return bed;
    }
}
