package administrador;

import herramientas.ConexionDB;
import javax.swing.*;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ModificarArtistaStrategy implements AccionStrategy {

    @Override
    public void ejecutar() {
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField txtIdArtista = new JTextField();
        JTextField txtNombre = new JTextField();
        JTextField txtNacionalidad = new JTextField();

        panelFormulario.add(new JLabel("ID del artista:"));
        panelFormulario.add(txtIdArtista);

        panelFormulario.add(new JLabel("Nuevo Nombre:"));
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Nueva Nacionalidad:"));
        panelFormulario.add(txtNacionalidad);

        int result = JOptionPane.showConfirmDialog(null, panelFormulario, "Modificar Artista", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "UPDATE Artistas SET nombre = ?, nacionalidad = ? WHERE id_artista = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtNombre.getText());
                stmt.setString(2, txtNacionalidad.getText());
                stmt.setInt(3, Integer.parseInt(txtIdArtista.getText()));

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Artista modificado exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al modificar el artista: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
