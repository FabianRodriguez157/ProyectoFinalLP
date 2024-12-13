package administrador;

import herramientas.ConexionDB;
import javax.swing.*;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AgregarArtistaStrategy implements AccionStrategy {

    @Override
    public void ejecutar() {
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(5, 2, 10, 10));

        JTextField txtNombre = new JTextField();
        JTextField txtNacionalidad = new JTextField();
        JTextField txtFechaNacimiento = new JTextField();
        JTextField txtFechaFallecimiento = new JTextField();
        JTextField txtBiografia = new JTextField();

        panelFormulario.add(new JLabel("Nombre:"));
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Nacionalidad:"));
        panelFormulario.add(txtNacionalidad);

        panelFormulario.add(new JLabel("Fecha de Nacimiento (YYYY-MM-DD):"));
        panelFormulario.add(txtFechaNacimiento);

        panelFormulario.add(new JLabel("Fecha de Fallecimiento (YYYY-MM-DD):"));
        panelFormulario.add(txtFechaFallecimiento);

        panelFormulario.add(new JLabel("Biografía:"));
        panelFormulario.add(txtBiografia);

        int result = JOptionPane.showConfirmDialog(null, panelFormulario, "Agregar Artista", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "INSERT INTO Artistas (nombre, nacionalidad, fecha_nacimiento, fecha_fallecimiento, biografia) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtNombre.getText());
                stmt.setString(2, txtNacionalidad.getText());
                stmt.setString(3, txtFechaNacimiento.getText());
                stmt.setString(4, txtFechaFallecimiento.getText());
                stmt.setString(5, txtBiografia.getText());

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Artista agregado exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al agregar el artista: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
