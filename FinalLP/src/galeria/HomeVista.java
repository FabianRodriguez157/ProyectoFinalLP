package galeria;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.List;

public class HomeVista extends JFrame {
 private JPanel panelObras;

 public HomeVista() {
     setTitle("Galería de Arte Virtual - Home");
     setSize(1080, 700);
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setLocationRelativeTo(null);
     setLayout(null);

     // Fondo crema
     getContentPane().setBackground(new Color(245, 245, 220));

     // Bienvenida
     JLabel lblBienvenida = new JLabel("Bienvenidos a la Galería de Arte");
     lblBienvenida.setFont(new Font("Serif", Font.BOLD, 24));
     lblBienvenida.setBounds(350, 20, 400, 30);
     add(lblBienvenida);

     // Descripción
     JLabel lblDescripcion = new JLabel("<html>Explora una selección de las mejores obras de arte de todos los tiempos.</html>");
     lblDescripcion.setFont(new Font("Serif", Font.PLAIN, 16));
     lblDescripcion.setBounds(350, 60, 400, 50);
     add(lblDescripcion);

     // Título de obras principales
     JLabel lblObrasPrincipales = new JLabel("Principales Obras");
     lblObrasPrincipales.setFont(new Font("Serif", Font.BOLD, 20));
     lblObrasPrincipales.setBounds(50, 130, 200, 30);
     add(lblObrasPrincipales);

     // Panel para las obras principales
     panelObras = new JPanel();
     panelObras.setLayout(new BoxLayout(panelObras, BoxLayout.Y_AXIS));
     panelObras.setBackground(new Color(160, 8 , 45)); // Color café

     JScrollPane scrollObras = new JScrollPane(panelObras);
     scrollObras.setBounds(50, 170, 980, 400);
     add(scrollObras);

     // Panel de información
     JPanel panelInformacion = new JPanel();
     panelInformacion.setBackground(new Color(105, 105, 105)); // Color oscuro
     panelInformacion.setBounds(50, 600, 980, 50);
     panelInformacion.setLayout(new FlowLayout(FlowLayout.LEFT));
     JLabel lblInformacion = new JLabel("Contacto: galeria@artevirtual.com | Teléfono: +51 987654321");
     lblInformacion.setForeground(Color.WHITE);
     panelInformacion.add(lblInformacion);
     add(panelInformacion);
     
 }

 public void mostrarObras(List<Obra> obras) {
	    panelObras.removeAll(); // Limpiar el panel antes de agregar nuevas obras

	    for (Obra obra : obras) {
	        JPanel panelObra = new JPanel();
	        panelObra.setLayout(new BorderLayout());
	        panelObra.setBackground(new Color(222, 184, 135)); // Fondo claro
	        panelObra.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	        panelObra.setMaximumSize(new Dimension(950, 350)); // Tamaño fijo para cada obra

	        // Cargar imagen
	        JLabel etiquetaImagen = new JLabel();
	        ImageIcon imagen = cargarImagenDesdeURL(obra.getImagenUrl(), 150, 150); // Ajusta el tamaño
	        etiquetaImagen.setIcon(imagen);

	        // Información de la obra
	        JPanel panelInfo = new JPanel();
	        panelInfo.setLayout(new GridLayout(2, 1)); // Dos filas: título y descripción
	        panelInfo.setBackground(new Color(222, 184, 135));
	        
	        JLabel etiquetaTitulo = new JLabel("Título: " + obra.getTitulo());
	        etiquetaTitulo.setFont(new Font("Serif", Font.BOLD, 14));
	        panelInfo.add(etiquetaTitulo);

	        JLabel etiquetaDescripcion = new JLabel("Descripción: " + obra.getDescripcion());
	        etiquetaDescripcion.setFont(new Font("Serif", Font.PLAIN, 12));
	        panelInfo.add(etiquetaDescripcion);

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


 @SuppressWarnings("deprecation")
private ImageIcon cargarImagenDesdeURL(String url, int ancho, int alto) {
     try {
         java.net.URL urlImagen = new java.net.URL(url);
         Image imagenOriginal = javax.imageio.ImageIO.read(urlImagen);

         if (imagenOriginal != null) {
             Image imagenEscalada = imagenOriginal.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH);
             return new ImageIcon(imagenEscalada);
         } else {
             return cargarImagenPlaceholder(ancho, alto);
         }
     } catch (IOException e) {
         e.printStackTrace();
         return cargarImagenPlaceholder(ancho, alto);
     }
 }

 private ImageIcon cargarImagenPlaceholder(int ancho, int alto) {
     try {
         Image imagenPlaceholder = javax.imageio.ImageIO.read(
                 new java.io.File("resources/images/imagen_no_disponible.png")
         );
         return new ImageIcon(imagenPlaceholder.getScaledInstance(ancho, alto, Image.SCALE_SMOOTH));
     } catch (IOException e) {
         e.printStackTrace();
         return new ImageIcon();
     }
 }

 public void mostrarAdvertencia(String mensaje) {
     JOptionPane.showMessageDialog(this, mensaje, "Advertencia", JOptionPane.WARNING_MESSAGE);
 }

 public void mostrarError(String mensaje) {
     JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
 }

    // Método para manejar la acción de mostrar detalles
 public void mostrarDetallesObra(Obra obra) {
	    String detalles = "Título: " + (obra.getTitulo() != null ? obra.getTitulo() : "No disponible") + "\n" +
	                      "Tipo: " + (obra.getTipo() != null ? obra.getTipo() : "No disponible") + "\n" +
	                      "Fecha de creación: " + (obra.getFechaCreacion() != null ? obra.getFechaCreacion() : "No disponible") + "\n" +
	                      "Técnica: " + (obra.getTecnica() != null ? obra.getTecnica() : "No disponible") + "\n" +
	                      "Dimensiones: " + (obra.getDimensiones() != null ? obra.getDimensiones() : "No disponible") + "\n" +
	                      "Descripción: " + (obra.getDescripcion() != null ? obra.getDescripcion() : "No disponible");

	    JOptionPane.showMessageDialog(this, detalles, "Detalles de la Obra", JOptionPane.INFORMATION_MESSAGE);
	}
    public JPanel getPanelObras() {
        return panelObras;
    }
    
}