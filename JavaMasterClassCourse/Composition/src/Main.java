public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(20, 20, 5);
        Case thecase = new Case("220B", "Dell", "240", dimensions);


        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27,
                new Resolution(254, 1440));     // Different way to create an instance of a class like above without making a handle.
                                                            // Can be good if you do not need to use a resolution instance. Just need to pass it do not want it for anything else.

        Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", 4, 6, "v2.44");

        PC thePC = new PC(thecase, theMonitor, theMotherboard);
//        Now if I want to draw something from method in the monitor class since we have not overridden anything in the PC class
        thePC.drawLogo();
        thePC.loadProgram();
        thePC.powerUp();

//        System.out.println(thePC.getMotherboard().getModel());
    }
}
