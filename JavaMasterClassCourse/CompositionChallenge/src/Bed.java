public class Bed {
    private String size;
    private int legs;
    private int bedFrame;

    public Bed(String size, int legs,int bedFrame) {
        this.size = size;
        this.legs = legs;
        this.bedFrame = bedFrame;
    }

//    getters
    public void getSize() {
        System.out.println(size);
    }

    public int getLegs() {
        return legs;
    }

    public int getBedFrame() {
        return bedFrame;
    }
}
