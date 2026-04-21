package net.salesianos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class InterfazRipAdvisor extends JFrame {
    private GestorRestaurantes gestor;
    private JTextArea areaTexto;

    public InterfazRipAdvisor() {
        gestor = new GestorRestaurantes();
        configurarVentana();
        crearMenu();
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

    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem anadir = new JMenuItem("Anadir restaurante");
        anadir.addActionListener(e -> anadirRestaurante());

        JMenuItem mostrar = new JMenuItem("Mostrar restaurantes");
        mostrar.addActionListener(e -> mostrarRestaurantes());

        menu.add(anadir);
        menu.add(mostrar);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void anadirRestaurante() {
    }
}