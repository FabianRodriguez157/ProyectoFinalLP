package administrador;

import herramientas.ConexionDB;
import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class EliminarArtistaStrategy implements AccionStrategy {

    @Override
    public void ejecutar() {
        String idArtista = JOptionPane.showInputDialog(null, "Ingrese el ID del artista a eliminar:");

        if (idArtista != null && !idArtista.isEmpty()) {
            try (Connection conn = ConexionDB.getConnection()) {
                String sql = "DELETE FROM Artistas WHERE id_artista = ?";
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(idArtista));

                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Artista eliminado exitosamente.");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error al eliminar el artista: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}
