package com.AWT;

import java.awt.*;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SplashScreen splash = SplashScreen.getSplashScreen();
        Rectangle bounds = splash.getBounds();
        Graphics2D g2 = splash.createGraphics();
        g2.setColor(Color.BLUE);
        for (int i=0; i<=100; i++){
            g2.fillRect(0,0, bounds.width*i/100, 30);
            splash.update();
            Thread.sleep(50);
        }
    }
}
