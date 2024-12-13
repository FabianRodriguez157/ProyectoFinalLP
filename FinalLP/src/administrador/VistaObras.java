package administrador;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VistaObras extends JFrame {
    private JButton btnAgregar, btnModificar, btnEliminar,btnVerArtistas;

    public VistaObras() {
        setTitle("Administrar Obras");
        setSize(600, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);

        JLabel label = new JLabel("Administrar Obras", SwingConstants.CENTER);
        label.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 18));
        add(label, BorderLayout.NORTH);

        JPanel panelBotones = new JPanel();
        btnAgregar = new JButton("Agregar");
        btnModificar = new JButton("Modificar");
        btnEliminar = new JButton("Eliminar");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnModificar);
        panelBotones.add(btnEliminar);

        add(panelBotones, BorderLayout.CENTER);

        btnAgregar.addActionListener(e -> ejecutarStrategy(new AgregarObraStrategy()));
        btnModificar.addActionListener(e -> ejecutarStrategy(new ModificarObraStrategy()));
        btnEliminar.addActionListener(e -> ejecutarStrategy(new EliminarObraStrategy()));
        
        btnVerArtistas = new JButton("Ver Artistas");
        JPanel panelBotones2 = new JPanel();
        panelBotones2.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panelBotones2.add(btnVerArtistas);

        add(panelBotones2, BorderLayout.SOUTH);

        // Acción para cambiar a la pantalla de artistas
        btnVerArtistas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirVistaArtistas();
            }
        });

        setVisible(true);
        
    }
    private void abrirVistaArtistas() {
        new VistaArtistas(); // Abre la pantalla de artistas
        dispose(); // Cierra la ventana actual
    }
    private void ejecutarStrategy(AccionStrategy strategy) {
        strategy.ejecutar();
    }
}
