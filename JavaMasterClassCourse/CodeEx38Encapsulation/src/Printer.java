public class Printer {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, boolean duplex) {
//        if((tonerLevel >=0) && (tonerLevel <= 100)) {
//            this.tonerLevel = tonerLevel;
//        } else {
//            this.tonerLevel = -1;
//        }
        this.tonerLevel = ((tonerLevel >= 0) && (tonerLevel <= 100)) ? tonerLevel : -1;
        this.duplex = duplex;
        this.pagesPrinted = 0;
    }

    public int addToner(int tonerAmount) {
        if((tonerAmount > 0) && (tonerLevel + tonerAmount <=100)) {
            return tonerLevel += tonerAmount;
        }

        return -1;
    }

    public int printPages(int pages) {
//        if(duplex) {
//            return pagesPrinted += Math.round((double) pages / 2);
//        }
//
//        return pagesPrinted += pages;
        return pagesPrinted += (duplex) ? (Math.round((double) pages / 2)) : pages;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
