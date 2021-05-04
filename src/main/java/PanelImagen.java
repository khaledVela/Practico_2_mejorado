import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JPanel;

public class PanelImagen extends JPanel implements PropertyChangeListener {
    private static final long serialVersionUID = 1L;
    private Imagen imagen;
    public PanelImagen(Imagen img) {
        imagen = img;
    }
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(397,511);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (imagen != null) {
            imagen.dibujar(g);
        }
    }
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        repaint();
    }
}