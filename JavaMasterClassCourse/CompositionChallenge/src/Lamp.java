public class Lamp {
    private int watts;
    private int size;
    private boolean state;

    public Lamp(int watts, int size, boolean state) {
        this.watts = watts;
        this.size = size;
        this.state = state;
    }

    public int getWatts() {
        return watts;
    }

    public int getSize() {
        return size;
    }

    public void isLampOn(boolean state) {
        System.out.println((state) ? "Lamp is turned on" : "Lamp is turned off");
    }
}
