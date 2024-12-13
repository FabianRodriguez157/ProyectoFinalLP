package administrador;

import herramientas.ConexionDB;
import javax.swing.*;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ModificarObraStrategy implements AccionStrategy {

    @Override
    public void ejecutar() {
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(3, 2, 10, 10));

        JTextField txtIdObra = new JTextField();
        JTextField txtNuevoTitulo = new JTextField();
        JTextField txtNuevaFecha = new JTextField();
        JTextField txtNuevoTipo = new JTextField();
        JTextField txtNuevaTecnica = new JTextField();
        JTextField txtNuevaDimension = new JTextField();
        JTextField txtNuevaDescripcion = new JTextField();
        JTextField txtNuevaUrl = new JTextField();
   
        

        panelFormulario.add(new JLabel("ID de la Obra:"));
        panelFormulario.add(txtIdObra);

        panelFormulario.add(new JLabel("Nuevo Título:"));
        panelFormulario.add(txtNuevoTitulo);
        
        panelFormulario.add(new JLabel("Fecha de Creación (YYYY-MM-DD):"));
        panelFormulario.add(txtNuevaFecha);

        panelFormulario.add(new JLabel("Nueva Tipo:"));
        panelFormulario.add(txtNuevoTipo);
        
        panelFormulario.add(new JLabel("Nueva Técnica:"));
        panelFormulario.add(txtNuevaTecnica);
        
        panelFormulario.add(new JLabel("Nuevas Dimensiones:"));
        panelFormulario.add(txtNuevaDimension);
        
        panelFormulario.add(new JLabel("Nueva Descripcion:"));
        panelFormulario.add(txtNuevaDescripcion);
        
        panelFormulario.add(new JLabel("Nueva Url:"));
        panelFormulario.add(txtNuevaUrl);

        int result = JOptionPane.showConfirmDialog(null, panelFormulario, "Modificar Obra", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "UPDATE Obras SET titulo = ?, tipo = ?, fecha_creacion = ?, tecnica = ?, dimensiones = ?, descripcion = ?, imagen_url = ? WHERE id_obra = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setString(1, txtNuevoTitulo.getText());
                stmt.setString(2, txtNuevoTipo.getText());
                stmt.setString(3, txtNuevaFecha.getText());
                stmt.setString(4, txtNuevaTecnica.getText());
                stmt.setString(5, txtNuevaDimension.getText());
                stmt.setString(6, txtNuevaDescripcion.getText());
                stmt.setString(8, txtNuevaUrl.getText());
                stmt.setInt(8, Integer.parseInt(txtIdObra.getText()));

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Obra modificada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al modificar la obra: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
