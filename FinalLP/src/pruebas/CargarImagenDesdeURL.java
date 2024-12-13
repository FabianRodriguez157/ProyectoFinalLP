package pruebas;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class CargarImagenDesdeURL {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Cargar Imagen desde URL");
            frame.setSize(400, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new BorderLayout());

            // URL de la imagen
            String urlImagen = "https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/1024px-React-icon.svg.png";

            // Cargar la imagen desde la URL
            ImageIcon imagenIcono = cargarImagenDesdeURL(urlImagen, 300, 300);
            if (imagenIcono != null) {
                JLabel etiquetaImagen = new JLabel(imagenIcono);
                etiquetaImagen.setHorizontalAlignment(SwingConstants.CENTER);
                frame.add(etiquetaImagen, BorderLayout.CENTER);
            } else {
                JLabel mensajeError = new JLabel("No se pudo cargar la imagen", SwingConstants.CENTER);
                frame.add(mensajeError, BorderLayout.CENTER);
            }

            frame.setVisible(true);
        });
    }

    // Método para cargar la imagen desde una URL
    private static ImageIcon cargarImagenDesdeURL(String url, int ancho, int alto) {
        try {
            URL urlImagen = new URL(url);
            Image imagenOriginal = javax.imageio.ImageIO.read(urlImagen);
            if (imagenOriginal != null) {
                Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
                return new ImageIcon(imagenEscalada);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; // Devuelve null si no se puede cargar la imagen
    }
}
