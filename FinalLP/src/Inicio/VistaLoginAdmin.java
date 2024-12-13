package Inicio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import herramientas.ConexionDB;
import administrador.*;

public class VistaLoginAdmin extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin;

    public VistaLoginAdmin() {
        setTitle("Login Administrador");
        setSize(400, 250);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        // Crear el panel central para los campos de usuario y contraseña
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(3, 2, 10, 10));
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        panelCentral.add(new JLabel("Usuario:"));
        txtUsuario = new JTextField();
        panelCentral.add(txtUsuario);

        panelCentral.add(new JLabel("Contraseña:"));
        txtContrasena = new JPasswordField();
        panelCentral.add(txtContrasena);

        btnLogin = new JButton("Iniciar Sesión");
        panelCentral.add(new JLabel()); // Espacio vacío para alinear el botón
        panelCentral.add(btnLogin);

        add(panelCentral, BorderLayout.CENTER);

        // Acción del botón
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                autenticarAdmin();
            }
        });

        setVisible(true);
    }

    private void autenticarAdmin() {
        String usuario = txtUsuario.getText();
        String contrasena = new String(txtContrasena.getPassword());

        try (Connection connection = ConexionDB.getConnection()) {
            // Corregir la consulta con parámetros seguros
            String sql = "SELECT * FROM administradores WHERE usuario = ? AND contrasena = ?";
            PreparedStatement stmt = connection.prepareStatement(sql);

            // Asignar los parámetros dinámicamente
            stmt.setString(1, usuario);
            stmt.setString(2, contrasena);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "¡Acceso concedido!", "Login", JOptionPane.INFORMATION_MESSAGE);
                new VistaObras();
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al conectar con la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
    }
}
