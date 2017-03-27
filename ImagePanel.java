package com.classe;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JComponent;

public class ImagePanel extends JComponent {
    private Image image;
    public ImagePanel() throws IOException {
        BufferedImage myimage = ImageIO.read(new File("C:\\Eclipse\\workspace\\ProjectJava\\menujava.png"));
        this.image = myimage;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
}