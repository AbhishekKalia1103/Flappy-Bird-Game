package iflappy;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class gamePanel extends JPanel {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 700;

    private int xCor = 0;
    private BufferedImage img = null;
    public static int score = 0;
    public static int highscore = 0;
    public static boolean GameOver = false;
    public static boolean starting = false;
    public static int proceed = -1;

    bird Bird = new bird();   //// bird  object
    piller pillerWall = new piller(gamePanel.WIDTH);
    piller pillerWall2 = new piller(gamePanel.WIDTH + (gamePanel.WIDTH / 2 + 30));

    public gamePanel() {

        loadImage();
        this.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                Bird.goupward();

            }
        });

    }

    private void loadImage() {
        try {
            img = ImageIO.read(new File("E://iflappy//src//images//gamepanelBG.png"));
            highscore = piller.getHighScore();
        } catch (Exception e) {
            System.out.println(""
                    + "Some Error to load menu image");
        }

    }

    public void paint(Graphics g) {

        super.paint(g);
        g.drawImage(img, xCor, 0, null);

        g.drawImage(img, xCor + 1400, 0, null);

        Bird.drawBird(g);
        pillerWall.drawPiller(g);
        pillerWall2.drawPiller(g);

        g.setFont(new Font("Times New Roman", Font.BOLD, 28));
        g.drawString("Score " + score, 150, 100);

        g.setFont(new Font("Times New Roman", Font.BOLD, 28));
        g.drawString(" High Score " + highscore, 350, 100);

        if (starting) {
            g.setColor(Color.WHITE);
            g.setFont(new Font("Algerian", Font.BOLD, 150));
            g.drawString(Integer.toString(proceed), WIDTH / 2 - 50, 250);

        }

    }

    public void MoveBird() {
        Bird.birdMovement();
        pillerWall.wall_Movement();
        pillerWall2.wall_Movement();
        if (GameOver) {
            pillerWall.X = gamePanel.WIDTH;
            pillerWall2.X = gamePanel.WIDTH + (gamePanel.WIDTH / 2 + 30);
            GameOver = false;
        }
        xCor += piller.speed;
        if (xCor == -1398) {
            xCor = 0;
        }
        if (pillerWall.X == bird.x || pillerWall.Y == bird.y) {
            score++;
            highscore = piller.getHighScore();

        }
        if (pillerWall2.X == bird.x || pillerWall2.Y == bird.y) {
            score++;

            highscore = piller.getHighScore();
        }
    }

    public static boolean popupmessage() {
        int result = JOptionPane.showConfirmDialog(null, "Game Over , Your Score: " + score + 
                "\nDo you want to restart", "Game Over", JOptionPane.YES_NO_OPTION);
        if (result == JOptionPane.YES_OPTION) {
            highscore = piller.getHighScore();
            return true;
        } else {
            return false;
        }
    }
}
