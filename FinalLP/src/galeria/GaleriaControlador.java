package galeria;

import herramientas.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GaleriaControlador {
    private HomeVista homeVista;
    
    public GaleriaControlador(HomeVista homeVista) {
        this.homeVista = homeVista;
        cargarPrincipalesObras();
    }
    private void cargarPrincipalesObras() {
        List<Obra> obras = new ArrayList<>();

        try (Connection conexion = ConexionDB.getConnection();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT id_obra, titulo, descripcion, tipo, fecha_creacion, tecnica, dimensiones, imagen_url FROM obras")) {

            while (rs.next()) {
            	int id2 = rs.getInt("id_obra");
                String titulo2 = rs.getString("titulo");
                String tipo = rs.getString("tipo");
                String fecha = rs.getString("fecha_creacion");
                String tecnica = rs.getString("tecnica");
                String dimensiones = rs.getString("dimensiones");
                String descripcion2 = rs.getString("descripcion");
                String imagenUrl = rs.getString("imagen_url");
                obras.add(new Obra(id2, titulo2, tipo, fecha, tecnica, dimensiones, descripcion2, imagenUrl));
            }
        } catch (SQLException e) {
            homeVista.mostrarError("Error al cargar las principales obras: " + e.getMessage());
        }

        homeVista.mostrarObras(obras);
    }

}