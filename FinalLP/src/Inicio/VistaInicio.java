package Inicio;

import javax.swing.*;

import galeria.GaleriaControlador;
import galeria.HomeVista;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class VistaInicio extends JFrame {
    private JButton btnIngresar;
    private JButton btnAdmin;

    public VistaInicio() {
        setTitle("Expositor de Arte Virtual");
        setSize(1080, 700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null); // Usamos null para posicionar los elementos libremente
        setLocationRelativeTo(null);

        // Crear el fondo con una imagen
        JLabel fondo = new JLabel(new ImageIcon("resources/images/galerias-arte.jpg"));
        fondo.setBounds(0, 0, 1080, 700);
        setContentPane(fondo);
        fondo.setLayout(null);
        
        //Panel oscuro central
        JPanel panelCentral = new JPanel();
        panelCentral.setBounds(380, 90, 320, 500); 
        panelCentral.setBackground(new Color(0, 0, 0, 90)); 
        panelCentral.setLayout(null); 
        fondo.add(panelCentral);

        // Crear el mensaje central
        JLabel mensaje = new JLabel("Bienvenido al Expositor");
        mensaje.setForeground(Color.WHITE);
        mensaje.setBounds(410, 300, 300, 50);
        try {
            Font fuentePersonalizada = Font.createFont(Font.TRUETYPE_FONT, new File("resources/fonts/Parisienne-Regular.ttf"));
            fuentePersonalizada = fuentePersonalizada.deriveFont(30f); // Tamaño de la fuente
            mensaje.setFont(fuentePersonalizada); // Aplicar la fuente al JLabel
        } catch (IOException | FontFormatException e) {
            e.printStackTrace();
            mensaje.setFont(new Font("Arial", Font.BOLD, 24)); // Fuente de respaldo
        }

        fondo.add(mensaje);

        // Crear botón de Ingresar
        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(490, 380, 100, 40);
        btnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Crear la ventana principal
                HomeVista homeVista = new HomeVista();

                // Crear el controlador para manejar la lógica de la vista
                GaleriaControlador controlador = new GaleriaControlador(homeVista);
                
                // Mostrar la ventana principal
                homeVista.setVisible(true);

                // Cerrar la ventana actual
                dispose();
            }
        });        fondo.add(btnIngresar);
        // Boton administrador
        btnAdmin = new JButton("Ingreso Administrador");
        btnAdmin.setBounds(850, 50, 170, 30);
        btnAdmin.addActionListener(e -> new VistaLoginAdmin());
        fondo.add(btnAdmin);

        setVisible(true);
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JButton getBtnAdmin() {
        return btnAdmin;
    }
}