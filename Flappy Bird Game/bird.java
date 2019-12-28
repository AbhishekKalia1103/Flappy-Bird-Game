package iflappy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class bird {

    public static int x = gamePanel.WIDTH / 2;
    public static int y = gamePanel.HEIGHT / 2;

    public static int downspeed = 2;
    public static int downacc = 1;

    private BufferedImage img = null;

    bird() {
        loadImage();
    }

    private void loadImage() {
        try {
            img = ImageIO.read(new File("E:/iflappy/src/images/bird2.png"));
        } catch (Exception e) {
            System.out.println("Error in bird image");
        }
    }

    public void drawBird(Graphics g) {
        g.drawImage(img, x, y, null);
    }

    public void birdMovement() {
        if (y > 0 && y < gamePanel.HEIGHT) {
            downspeed = downspeed + downacc;
            y = y + downspeed;
        } else {

            boolean option = gamePanel.popupmessage();

            if (option) {
                try {
                    Thread.sleep(500);

                } catch (Exception e) {
                    e.printStackTrace();
                }

                reset();
                gamePanel.score = 0;
            } else {
                iflappy_Main.window.dispose();
                iflappy_Main.timer.stop();
            }

        }
    }

    public void goupward() {
        downspeed = -12;

    }

    public static void reset() {
        y = gamePanel.HEIGHT / 2;
        downspeed = 2;
        downacc = 1;
        gamePanel.GameOver = true;

    }
    public static Rectangle getBirdRect() {
        Rectangle BirdRect = new Rectangle(x, y, 50, 50);
        return BirdRect;

    }
}
