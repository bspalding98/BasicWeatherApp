package com.company;

public class Main {

    public static void main(String[] args) {

        Printer printer = new Printer(200, false);
//        System.out.println(printer.getTonerLevel());
//        printer.fillToner(51);
//        System.out.println(printer.getTonerLevel());
//        printer.fillToner(20);
//        System.out.println(printer.getTonerLevel());

        System.out.println(printer.getNumberOfPagesPrinted());
        printer.printPage(3);

        printer.isDuplexPrinter(true);
        printer.printPage(5);

        printer.isDuplexPrinter(false);
        printer.printPage(5);
    }
}
