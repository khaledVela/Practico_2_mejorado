import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class Imagen1 extends Transformacion {

    private BufferedImage foto= null;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    private int color;
    private int ancho;
    public Imagen1(Imagen foto) {
        imagenBase = foto;
    }

    @Override
    public void hacer() {
        try {
            File imagen = new File("angel.jpg");
            foto = ImageIO.read(imagen);
            ancho=foto.getWidth()/3;
            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = 0; j <ancho; j++) {
                    color = foto.getRGB(j, i);
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se hace muestra parte 100%");
            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = ancho; j < ancho*2; j++) {
                    color = foto.getRGB(j, i) / 2;
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se hace muestra parte 50%");

            for (int i = 0; i < foto.getHeight(); i++) {
                for (int j = ancho*2; j < ancho*3; j++) {
                    color = foto.getRGB(j, i) *0;
                    imagenBase.setPixel(color, j, i);
                }
            }
            logger.debug("Se hace muestra parte 0%");

            imagenBase.cambioOk();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}