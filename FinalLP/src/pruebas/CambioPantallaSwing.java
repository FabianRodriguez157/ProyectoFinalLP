package pruebas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CambioPantallaSwing extends JFrame {
    private CardLayout cardLayout;
    private JPanel panelContenedor;
    
    public CambioPantallaSwing() {
        setTitle("Cambio de Pantallas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        // Usamos CardLayout para manejar las pantallas
        cardLayout = new CardLayout();
        panelContenedor = new JPanel(cardLayout);
        
        // Crear las pantallas
        JPanel pantalla1 = crearPantalla1();
        JPanel pantalla2 = crearPantalla2();
        
        // Añadir las pantallas al panel contenedor
        panelContenedor.add(pantalla1, "Pantalla1");
        panelContenedor.add(pantalla2, "Pantalla2");
        
        // Añadir panel contenedor a la ventana
        add(panelContenedor);
        
        // Mostrar pantalla inicial
        cardLayout.show(panelContenedor, "Pantalla1");
        
        setVisible(true);
    }

    // Método para crear la primera pantalla
    private JPanel crearPantalla1() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton btnIrPantalla2 = new JButton("Ir a Pantalla 2");
        
        // Acción para cambiar a la segunda pantalla
        btnIrPantalla2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "Pantalla2");
            }
        });
        
        panel.add(new JLabel("Esta es la Pantalla 1"), BorderLayout.CENTER);
        panel.add(btnIrPantalla2, BorderLayout.SOUTH);
        return panel;
    }

    // Método para crear la segunda pantalla
    private JPanel crearPantalla2() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JButton btnIrPantalla1 = new JButton("Volver a Pantalla 1");
        
        // Acción para cambiar a la primera pantalla
        btnIrPantalla1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(panelContenedor, "Pantalla1");
            }
        });
        
        panel.add(new JLabel("Esta es la Pantalla 2"), BorderLayout.CENTER);
        panel.add(btnIrPantalla1, BorderLayout.SOUTH);
        return panel;
    }

    public static void main(String[] args) {
        new CambioPantallaSwing();
    }
}
