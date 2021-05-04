import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Visual extends JFrame implements ActionListener{
    private static final long serialVersionUID = 1L;
    private final static Logger logger = (Logger) LogManager.getRootLogger();
    private Imagen modelo;
    private JMenuBar menuBar = new JMenuBar();
    private JMenu mnuImagen = new JMenu("Menu");
    private JMenuItem item = new JMenuItem("Imagen 1");
    private JMenuItem item2 = new JMenuItem("Imagen 2");
    private JMenuItem item3 = new JMenuItem("Resultante");
    private JMenuItem item4 = new JMenuItem("Info");

    public Visual() {
        super("Practico 2");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        init();
    }

    public void init() {
        logger.debug("Creo menu");
        modelo = new Imagen(397, 511);
        PanelImagen panel = new PanelImagen(modelo);
        modelo.addObserver(panel);
        this.getContentPane().setLayout(new BorderLayout());
        this.getContentPane().add(panel, BorderLayout.CENTER);
        item.addActionListener(this);
        item2.addActionListener(this);
        item3.addActionListener(this);
        item4.addActionListener(this);
        mnuImagen.add(item);
        mnuImagen.add(item2);
        mnuImagen.add(item3);
        mnuImagen.add(item4);
        menuBar.add(mnuImagen);
        this.setJMenuBar(menuBar);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == item) {
            logger.debug("Cargo imagen 1");
            Imagen1 f= new Imagen1(modelo);
            f.hacer();
        }
        if (e.getSource() == item2) {
            logger.debug("Cargo imagen 2");
            Imagen2 f= new Imagen2(modelo);
            f.hacer();
        }
        if (e.getSource() == item3) {
            logger.debug("Cargo resultado");
            Mixto f= new Mixto(modelo);
            f.hacer();
        }
        if (e.getSource() == item4) {
            logger.debug("Doy un mini informe");
            JOptionPane.showMessageDialog(null, "Programa de dos imagenes\nImagenes de 397px x 511px");

        }
    }
}

