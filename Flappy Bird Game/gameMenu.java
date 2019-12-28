package iflappy;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

public class gameMenu extends JPanel implements ActionListener {

    JButton btn;
    private BufferedImage img = null;
    public boolean start = false;
    Color lightBlue = new Color(67, 153, 255);

    public gameMenu() {
        btn = new JButton(new ImageIcon("E:/iflappy/src/images/play.png"));
        btn.setBackground(lightBlue);
        btn.setBounds(230, 280, 100, 100);
        btn.addActionListener(this);
        add(btn);
        loadImage();
    }

    private void loadImage() {
        try {
            img = ImageIO.read(new File("E://iflappy//src//images//bg.png"));
        } catch (Exception e) {
            System.out.println( "Some Error to load menu image");
        }
    }

    @Override
    public void paint(Graphics g) {

        super.paint(g);
        g.drawImage(img, 0, 0, gamePanel.WIDTH, gamePanel.HEIGHT, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Curlz MT", Font.PLAIN, 120));
        g.drawString("iFlappy ", 130, 200);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        remove(btn);
        start = true;
    }
}
