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
        String nombre = Validaciones.solicitarCadena("Nombre:", "Anadir");
        if (Validaciones.esCadenaVacia(nombre)) {
            Validaciones.mostrarMensaje("El nombre no puede estar vacio", "Error");
            return;
        }

        String direccion = Validaciones.solicitarCadena("Direccion:", "Anadir");
        String tipo = Validaciones.solicitarCadena("Tipo de cocina:", "Anadir");

        int puntos = Validaciones.solicitarEntero("Puntuacion (1-5):", "Anadir");
        if (!Validaciones.esPuntuacionValida(puntos)) {
            Validaciones.mostrarMensaje("Puntuacion invalida", "Error");
            return;
        }

        String valoracion = Validaciones.solicitarCadena("Valoracion:", "Anadir");

        Restaurante r = new Restaurante(nombre, direccion, tipo, puntos, valoracion);
        gestor.anadirRestaurante(r);
        Validaciones.mostrarMensaje("Restaurante anadido", "OK");
    }

    private void mostrarRestaurantes() {
        if (gestor.getCantidad() == 0) {
            areaTexto.setText("No hay restaurantes");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Restaurante r : gestor.getRestaurantes()) {
            sb.append(r.toString()).append("\n\n");
        }
        areaTexto.setText(sb.toString());
    }
}