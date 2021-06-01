package com.AWT;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

    public static void main(String[] args) throws InterruptedException, IOException {
        SplashScreen splash = SplashScreen.getSplashScreen();
        Rectangle bounds = splash.getBounds();
        Graphics2D g2 = splash.createGraphics();
        g2.setColor(Color.BLUE);
        for (int i=0; i<=100; i++){
            g2.fillRect(0,0, bounds.width*i/100, 30);
            splash.update();
            Thread.sleep(10);
        }

        final  JFrame splashFrame = new JFrame();
        final JPanel splashPanel = new JPanel();
        splashPanel.setLayout(new BoxLayout(splashPanel, BoxLayout.Y_AXIS));

        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setSize(splash.getBounds().width, 20);
        splashPanel.add(progressBar);

        final BufferedImage img = ImageIO.read(new File("1.jpg"));
        JLabel imageLabel = new JLabel(new ImageIcon(img));
        splashPanel.add(imageLabel).setBounds(splash.getBounds());

        splashFrame.add(splashPanel);
        splashFrame.setBounds(splash.getBounds());
        splashFrame.setVisible(true);

        try {
            for (int i=0;i<100;i++){
                progressBar.setString("Load: "+i);
                progressBar.setValue(i);
                splashPanel.repaint();
                Thread.sleep(20);
            }
        }catch (InterruptedException e){

        }
        splashFrame.setVisible(false);
    }
}
