package iflappy;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class iflappy_Main {
    static JFrame window;
    public static Timer timer, timer2;
    private int proceed = 4;
    public iflappy_Main() {
        window = new JFrame();
        window.setSize(600, 800);
        window.setResizable(false);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("iFlappy");
        window.setLocationRelativeTo(null);
    }
    void display() {
        gameMenu menu = new gameMenu();
        gamePanel game = new gamePanel();
        timer = new Timer(20, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.repaint();
                game.MoveBird();
            }
        });
        window.setVisible(true);
        window.add(menu);
        menu.setLayout(null);
        while (menu.start == false) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
        window.remove(menu);
        window.add(game);
        game.setVisible(true);
        window.revalidate();
        timer2 = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                proceed--;
                gamePanel.proceed = proceed;
                gamePanel.starting = true;
                game.repaint();
                if (proceed == 0) {
                    timer2.stop();
                    timer.start();
                    gamePanel.starting = false;
                }}   
        });
        timer2.start();
    }
    public static void main(String[] args) {
        iflappy_Main flappy = new iflappy_Main();       
       flappy.display();}
    }
