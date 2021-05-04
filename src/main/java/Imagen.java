import javax.imageio.ImageIO;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.io.IOException;

public class Imagen {
    BufferedImage foto= null;
    private int[][] pixeles;
    private int ancho;
    private int alto;
    File imagen = new File("caratula.jpg");
    private PropertyChangeSupport observed;

    public Imagen(int w, int h) {
        pixeles = new int[w][h];
        ancho = w;
        alto = h;
        try {
            foto = ImageIO.read(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < alto; i++) {
            for (int j = 0; j < ancho; j++) {
                int color = foto.getRGB(j, i);
                setPixel(color, j, i);
            }
        }

        observed = new PropertyChangeSupport(this);
    }
    public Imagen(File nuevo) {

        try {
            imagen= nuevo;
            foto = ImageIO.read(imagen);
        } catch (IOException e) {
            e.printStackTrace();
        }
        pixeles = new int[foto.getWidth()][foto.getHeight()];
        ancho = foto.getWidth();
        alto = foto.getHeight();

        observed = new PropertyChangeSupport(this);
    }
    public void addObserver(PropertyChangeListener panel) {
        observed.addPropertyChangeListener(panel);
    }

    public int getAncho() {
        return ancho;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAlto() {
        return alto;
    }

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public void setPixel(int c, int x, int y) {
        pixeles[x][y] = c;
    }

    public int getPixel(int x, int y) {
        return pixeles[x][y];
    }

    public void dibujar(Graphics g) {
        BufferedImage rsm = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = rsm.createGraphics();

        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                g2d.setColor(new Color(pixeles[i][j]));
                g2d.drawLine(i, j, i, j);
            }
        }

        g.drawImage(rsm, 0, 0, null);
    }

    public void cambioOk() {
        observed.firePropertyChange("Imagen", 1, 2);
    }
}