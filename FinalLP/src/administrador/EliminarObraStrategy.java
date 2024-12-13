package administrador;

import herramientas.ConexionDB;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EliminarObraStrategy implements AccionStrategy {

    @Override
    public void ejecutar() {
        String idObra = JOptionPane.showInputDialog(null, "Ingrese el ID de la obra a eliminar:");

        if (idObra != null && !idObra.isEmpty()) {
            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "DELETE FROM Obras WHERE id_obra = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(idObra));

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Obra eliminada exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar la obra: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
