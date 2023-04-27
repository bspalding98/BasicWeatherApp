package com.example.awtSample;

import java.awt.*;  // * means import all classes, interfaces and static objects. awt = abstract windows toolkit. Package provides everything to create the awt interface. If it needs to be upgraded. Just deploy new packages instead of updating files scattered in the JDK

import java.awt.event.WindowAdapter;    // These are still needed because this is a differ package. It's java.awt.event SO could make this a * and delete one below it wanted
import java.awt.event.WindowEvent;

public class MyWindow extends Frame {
    public MyWindow(String title) {
        super(title);
        setSize(500, 140);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Font sansSerifLarge = new Font("SansSerif", Font.BOLD, 18);
        Font sansSerifSmall = new Font("SansSerif", Font.BOLD, 12);
        g.setFont(sansSerifLarge);
        g.drawString("The Complete Java Developer Course", 60, 60);
        g.setFont(sansSerifSmall);
        g.drawString("by Boyd Spalding", 60, 100);
    }
}
