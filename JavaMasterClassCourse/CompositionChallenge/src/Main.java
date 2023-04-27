public class Main {

    public static void main(String[] args) {

        BedRoom bedRoom = new BedRoom();
        bedRoom.getBed().getSize();
        bedRoom.isLampOn(false);
        bedRoom.isLampOn(true);


        Lamp lamp = new Lamp(30, 3, false);
        Bed bed = new Bed("King", 3, 1);
        BedRoom bedRoom1 = new BedRoom(lamp, bed, new Window(10, 10, 4));
        bedRoom1.getBed().getSize();
        bedRoom1.getBedSize();
        bedRoom1.isLampOn(true);
        bedRoom1.isLampOn(false);
        System.out.println(bedRoom1.getWindows().getPanels());
        lamp.isLampOn(false);


    }
}
