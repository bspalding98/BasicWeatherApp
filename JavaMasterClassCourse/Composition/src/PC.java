public class PC {
//    THis is composition:
//    It has a case which is comprised of a model, manufacturer, power supply, and dimensions where dimensions are comprised
//    of a height, width, and depth.
//    We have monitor which has several elements like model, manufacturer, size and resolution. Where a resolution has width and height
//    We lastly have a motherboard which has a model, manufacturer, ram slots, card slots and bios.

//    COMPOSITION IS GOOD BECAUSE WITH INHERITANCE YOU CAN ONLY INHERIT ONE AT A TIME. HERE WE HAVE COMPOSED THREE CLASSES.
//    Now we could make a certain PC like Acer predator which could inherit the PC class???? WHich is composed of all the others.
    private Case theCase;   // Named "theCase" because case is a keyword
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Case theCase, Monitor monitor, Motherboard motherboard) {
        this.theCase = theCase;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    //    These gets essentially give you access to the other classes.
    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
    }

    public void drawLogo() {
        // Fancy Graphics
        monitor.drawPixelAt(1200, 50, "yellow");        // Would create getters and have say getMonitor() If we had to do some validation if necessary
    }

    public void loadProgram() {
        motherboard.loadProgram("Windows 1.0");
    }
}
