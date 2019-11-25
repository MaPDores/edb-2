package view.utils;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * @author marcelo
 * 
 * Classe que se responsabiliza da criação de imagens.
 * (Factory design pattern)
 */
public class ImageFactory {
    
    private static ImageFactory instance;
    
    private ImageFactory() {}
    
    public static ImageFactory getInstance() {
        if (instance == null)
            instance = new ImageFactory();
        return instance;
    }

    public ImageIcon createImageIcon(String source) {
        Image img = null;
        try {
            img = ImageIO.read(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ImageIcon(img);
    }
    
    public Image createImage(String source) {
        Image img = null;
        try {
         img = ImageIO.read(getClass().getResource(source));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return img;
    }
    
    public ImageIcon createResizedImageIcon(ImageIcon imgIcon, int width, int height) {
        Image image = imgIcon.getImage();
        return new ImageIcon(image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH));
    }
}
