package com.company;

public class Printer {
    private int tonerLevel = 50;
    private int numberOfPagesPrinted;   // Do not initialise with a value as the number of pages printed should be 0 everytime as you havent printed yet.
    private boolean duplexPrinter;

    public Printer(int tonerLevel, boolean duplexPrinter) {
        if((tonerLevel >= 0) && (tonerLevel <= 100)) {
            this.tonerLevel = tonerLevel;
        }
        this.duplexPrinter = duplexPrinter;
        this.numberOfPagesPrinted = 0;
    }



    public void isDuplexPrinter(boolean state) {
        duplexPrinter = state;
    }

    public boolean isDuplexPrinter() {
        return duplexPrinter;
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public void fillToner(int amount) {
        if((tonerLevel > 0) && ((tonerLevel + amount) <= 100)) {
            System.out.println("Toner level was at " + tonerLevel + " and is being filled up another " + amount);
            tonerLevel += amount;
            System.out.println("New Toner level is " + tonerLevel);
        } else {
            System.out.println("Sorry toner level is already " + tonerLevel + " adding " + amount +
                    " would overfill it. So this cannot be done");
            System.out.println("Toner level is " +tonerLevel);
        }
    }

    public void printPage(int amount) {
        if(isDuplexPrinter()) {
            numberOfPagesPrinted += Math.round((double) amount / 2);        // COuld just do divison of amount here and then have no else statement and always run where else is so only need one similar operation.
            System.out.println("You have now printed " + getNumberOfPagesPrinted());
        } else {
            numberOfPagesPrinted += amount;
            System.out.println("You have now printed " + getNumberOfPagesPrinted());     // Could also just not have a getter for it and print field. However it cannot be updated manually then.
        }
    }
}
