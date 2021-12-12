package com.javalearning.simpleanimation;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    private void go() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();
        frame.getContentPane().add(drawPanel);
        frame.setSize(1000, 1000);
        frame.setVisible(true);
        for (int i = 0; i < 130; i++) {
            x = x + 3;
            //y = y + 3;
            drawPanel.repaint();
            try {
                Thread.sleep(50);
            }catch (Exception ex){}
        }

    }

    class MyDrawPanel extends JPanel {
        public void paintComponent(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.GREEN);
            g.fillOval(x, y, 40, 40);
        }
    }
}
