package net.salesianos;

import javax.swing.*;
import java.awt.*;

public class InterfazRipAdvisor extends JFrame {
    private GestorRestaurantes gestor;
    private JTextArea areaTexto;

    public InterfazRipAdvisor() {
        gestor = new GestorRestaurantes();
        configurarVentana();
        crearArea();
    }

    private void configurarVentana() {
        setTitle("RipAdvisor");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void crearArea() {
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);
    }
}