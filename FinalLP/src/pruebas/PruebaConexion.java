package pruebas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class PruebaConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/galeriaartevirtual";
        String user = "root";
        String password = "fabi7890";

        try {
            // Establecer la conexión con la base de datos
            Connection connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos.");

            // Crear un Statement para ejecutar una consulta
            Statement statement = connection.createStatement();
            
            // Realizar una consulta simple (por ejemplo, obtener la lista de bases de datos)
            ResultSet resultSet = statement.executeQuery("SHOW TABLES"); // Lista las tablas en la base de datos
            
            System.out.println("Tablas en la base de datos:");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1)); // Imprime el nombre de cada tabla
            }

            // Cerrar recursos
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }
}
