package galeria;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ArtistasVista extends JFrame {
    private JPanel panelArtistas; 

    public ArtistasVista() {
        setTitle("Galería de Arte Virtual - Artistas");
        setSize(1080, 700);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 245, 220));

        JLabel titulo = new JLabel("Artistas Principales", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        // Aquí inicializamos el panel correctamente
        panelArtistas = new JPanel();
        panelArtistas.setBackground(new Color(245, 245, 220));
        panelArtistas.setLayout(new BoxLayout(panelArtistas, BoxLayout.Y_AXIS));

        // Lo añadimos a un JScrollPane para que sea desplazable
        JScrollPane scrollPane = new JScrollPane(panelArtistas);
        add(scrollPane, BorderLayout.CENTER);
    }

    public void mostrarArtistas(List<Artista> artistas) {
        // Limpia los componentes previos si los hubiera
        for (Artista artista : artistas) {
            JLabel lblArtista = new JLabel("<html><b>Nombre:</b> " + artista.getNombre() +
                "<br><b>Nacionalidad:</b> " + artista.getNacionalidad() +
                "<br><b>Fecha nacimiento:</b> " + artista.getFechaNacimiento() +
                "<br><b>Fecha fallecimiento:</b> " + artista.getFechaFallecimiento() +
                "<br><b>Biografía:</b> " + artista.getBiografia() + "</html>");
            lblArtista.setFont(new Font("Serif", Font.PLAIN, 12));
            lblArtista.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
            panelArtistas.add(lblArtista);
        }

        // Actualiza el panel después de agregar los componentes
        panelArtistas.revalidate();
        panelArtistas.repaint();
    }
}