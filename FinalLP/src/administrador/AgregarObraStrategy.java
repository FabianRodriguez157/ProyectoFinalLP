package administrador;

import herramientas.ConexionDB;
import javax.swing.*;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AgregarObraStrategy implements AccionStrategy {

    @Override
    public void ejecutar() {
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(7, 2, 10, 10));

        JTextField txtTitulo = new JTextField();
        JTextField txtFechaCreacion = new JTextField();
        JTextField txtTipo = new JTextField();
        JTextField txtTecnica = new JTextField();
        JTextField txtDimensiones = new JTextField();
        JTextField txtDescripcion = new JTextField();
        JTextField txtUrlImagen = new JTextField();
        JTextField campoIdArtista = new JTextField();


        panelFormulario.add(new JLabel("Título:"));
        panelFormulario.add(txtTitulo);

        panelFormulario.add(new JLabel("Fecha de Creación (YYYY-MM-DD):"));
        panelFormulario.add(txtFechaCreacion);
        
        panelFormulario.add(new JLabel("Tipo:"));
        panelFormulario.add(txtTipo);

        panelFormulario.add(new JLabel("Técnica:"));
        panelFormulario.add(txtTecnica);

        panelFormulario.add(new JLabel("Dimensiones:"));
        panelFormulario.add(txtDimensiones);

        panelFormulario.add(new JLabel("Descripción:"));
        panelFormulario.add(txtDescripcion);

        panelFormulario.add(new JLabel("Url de la imagen:"));
        panelFormulario.add(txtUrlImagen);
        
        panelFormulario.add(new JLabel("ID del artista referenciado:"));
        panelFormulario.add(campoIdArtista);

        int result = JOptionPane.showConfirmDialog(null, panelFormulario, "Agregar Obra", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "INSERT INTO Obras (titulo, fecha_creacion, tipo, tecnica, dimensiones, descripcion, imagen_url, id_artista) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtTitulo.getText());
                stmt.setString(2, txtFechaCreacion.getText());
                stmt.setString(3, txtTipo.getText());
                stmt.setString(4, txtTecnica.getText());
                stmt.setString(5, txtDimensiones.getText());
                stmt.setString(6, txtDescripcion.getText());
                stmt.setString(7, txtUrlImagen.getText());
                stmt.setInt(8, Integer.parseInt(campoIdArtista.getText()));
                

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Obra agregada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar la obra: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
