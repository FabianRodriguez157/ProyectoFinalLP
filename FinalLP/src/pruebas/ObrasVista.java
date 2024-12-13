package pruebas;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class ObrasVista extends JFrame {
    private JPanel panelObras;

    public ObrasVista() {
        setTitle("Galería de Arte Virtual - Obras");
        setSize(1080, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Fondo crema
        getContentPane().setBackground(new Color(245, 245, 220));

        // Título
        JLabel lblTitulo = new JLabel("Lista Completa de Obras");
        lblTitulo.setFont(new Font("Serif", Font.BOLD, 24));
        lblTitulo.setBounds(350, 20, 400, 30);
        add(lblTitulo);

        // Panel de obras
        panelObras = new JPanel();
        panelObras.setLayout(new BoxLayout(panelObras, BoxLayout.Y_AXIS));
        panelObras.setBackground(new Color(160, 82, 45)); // Color café
        panelObras.setBounds(50, 70, 980, 550);
        panelObras.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JScrollPane scrollObras = new JScrollPane(panelObras);
        scrollObras.setBounds(50, 70, 980, 550);
        add(scrollObras);

        // Botón regresar
        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setBounds(50, 640, 100, 30);
        btnRegresar.addActionListener(e -> dispose());
        add(btnRegresar);
    }

    // Método para cargar imágenes desde URLs
    private ImageIcon cargarImagenDesdeURL(String url, int ancho, int alto) {
        try {
            java.net.URL urlImagen = new java.net.URL(url);
            Image imagenOriginal = javax.imageio.ImageIO.read(urlImagen);
            Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
            return new ImageIcon(imagenEscalada);
        } catch (IOException e) {
            e.printStackTrace();
            return new ImageIcon(new ImageIcon("resources/images/imagen_no_disponible.jpg")
                    .getImage().getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
        }
    }

    // Método para mostrar la lista completa de obras
    /**public void mostrarObras(List<Obra> obras) {
        panelObras.removeAll(); // Limpiar el panel antes de agregar nuevas obras

        for (Obra obra : obras) {
            JPanel panelObra = new JPanel();
            panelObra.setLayout(new BorderLayout());
            panelObra.setBackground(new Color(222, 184, 135)); // Fondo claro
            panelObra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
            panelObra.setMaximumSize(new Dimension(950, 150)); // Tamaño fijo para cada obra

            // Cargar imagen
            JLabel etiquetaImagen = new JLabel();
            ImageIcon imagen = cargarImagenDesdeURL(obra.getImagenUrl(), 150, 150); // Ajusta el tamaño
            etiquetaImagen.setIcon(imagen);

            // Información de la obra
            JPanel panelInfo = new JPanel();
            panelInfo.setLayout(new GridLayout(3, 1));
            panelInfo.setBackground(new Color(222, 184, 135));
            JLabel etiquetaTitulo = new JLabel("Título: " + obra.getTitulo());
            JLabel etiquetaTipo = new JLabel("Tipo: " + obra.getTipo());
            panelInfo.add(etiquetaTitulo);
            panelInfo.add(etiquetaTipo);

            // Botón "Detalles"
            JButton btnDetalles = new JButton("Detalles");
            btnDetalles.addActionListener(e -> mostrarDetallesObra(obra));

            // Añadir componentes al panel de la obra
            panelObra.add(etiquetaImagen, BorderLayout.WEST);
            panelObra.add(panelInfo, BorderLayout.CENTER);
            panelObra.add(btnDetalles, BorderLayout.EAST);

            // Añadir al panel principal
            panelObras.add(panelObra);
        }

        panelObras.revalidate();
        panelObras.repaint();
    }

    // Método para manejar la acción de mostrar detalles
    private void mostrarDetallesObra(Obra obra) {
        JOptionPane.showMessageDialog(this,
                "Título: " + obra.getTitulo() + "\n" +
                        "Tipo: " + obra.getTipo() + "\n" +
                        "Dimensiones: " + obra.getDimensiones() + "\n" +
                        "Fecha de creación: " + obra.getFechaCreacion() + "\n" +
                        "Técnica: " + obra.getTecnica() + "\n" +
                        "Descripción: " + obra.getDescripcion(),
                "Detalles de la Obra", JOptionPane.INFORMATION_MESSAGE);
    }
    public JPanel getPanelObras() {
        return panelObras;
    }**/
}
