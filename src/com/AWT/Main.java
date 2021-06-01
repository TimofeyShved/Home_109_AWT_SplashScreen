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
        SplashScreen splash = SplashScreen.getSplashScreen(); // достаём скрин загрузки из настроек программы
        Rectangle bounds = splash.getBounds(); // создаём прямоугольник
        Graphics2D g2 = splash.createGraphics(); // создаём графику на скрине
        g2.setColor(Color.BLUE); // выбираем цвет синий
        for (int i=0; i<=100; i++){ // цикл до 100
            g2.fillRect(0,0, bounds.width*i/100, 30); // закрашиваем
            splash.update(); // обновляем скрин
            Thread.sleep(10); // задержка в 10 милисекунд
        }

        // ------------------------------------------------------------------------- 2 вариант

        final  JFrame splashFrame = new JFrame(); // создаём форму
        final JPanel splashPanel = new JPanel(); // создаём панель
        splashPanel.setLayout(new BoxLayout(splashPanel, BoxLayout.Y_AXIS)); // устанавливаем вид отображения VBOX

        final JProgressBar progressBar = new JProgressBar(); // создаём прогресс
        progressBar.setStringPainted(true); // отрисовка текста
        progressBar.setSize(splash.getBounds().width, 20); // размеры
        splashPanel.add(progressBar); // добавить на панель

        final BufferedImage img = ImageIO.read(new File("1.jpg")); // берем картинку
        JLabel imageLabel = new JLabel(new ImageIcon(img)); // закидываем в метку
        splashPanel.add(imageLabel).setBounds(splash.getBounds()); // а её в панель

        splashFrame.add(splashPanel); // панель на форму
        splashFrame.setBounds(splash.getBounds()); // размер формы
        splashFrame.setVisible(true); // видимость

        try {
            for (int i=0;i<100;i++){ // цикл
                progressBar.setString("Load: "+i); // прогресс
                progressBar.setValue(i);
                splashPanel.repaint(); // перерисовка
                Thread.sleep(20); // задержка
            }
        }catch (InterruptedException e){

        }
        splashFrame.setVisible(false); // видимость
        System.exit(0);
    }
}
