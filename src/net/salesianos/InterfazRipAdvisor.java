package net.salesianos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Interfaz grafica de la aplicacion RipAdvisor.
 */
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

    private void crearMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Opciones");

        JMenuItem anadir = new JMenuItem("Anadir restaurante");
        anadir.addActionListener(e -> anadirRestaurante());

        JMenuItem mostrar = new JMenuItem("Mostrar restaurantes");
        mostrar.addActionListener(e -> mostrarRestaurantes());

        JMenuItem editar = new JMenuItem("Editar restaurante");
        editar.addActionListener(e -> editarRestaurante());

        JMenuItem eliminar = new JMenuItem("Eliminar restaurante");
        eliminar.addActionListener(e -> eliminarRestaurante());

        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> salir());

        menu.add(anadir);
        menu.add(mostrar);
        menu.add(editar);
        menu.add(eliminar);
        menu.add(salir);

        menuBar.add(menu);
        setJMenuBar(menuBar);
    }

    private void crearArea() {
        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);
        add(scroll, BorderLayout.CENTER);
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

    private void editarRestaurante() {
        if (gestor.getCantidad() == 0) {
            Validaciones.mostrarMensaje("No hay restaurantes", "Error");
            return;
        }
        String nuevoNombre = Validaciones.solicitarCadena("Nuevo nombre:", "Editar");
        if (!Validaciones.esCadenaVacia(nuevoNombre)) {
            gestor.getRestaurantes().get(0).setNombre(nuevoNombre);
            Validaciones.mostrarMensaje("Editado", "OK");
        }
    }

    private void eliminarRestaurante() {
        if (gestor.getCantidad() == 0) {
            Validaciones.mostrarMensaje("No hay restaurantes", "Error");
            return;
        }
        int opcion = Validaciones.mostrarConfirmacion("¿Eliminar?", "Eliminar");
        if (opcion == JOptionPane.YES_OPTION) {
            gestor.eliminarRestaurante(0);
            Validaciones.mostrarMensaje("Eliminado", "OK");
        }
    }

    private void salir() {
        int opcion = Validaciones.mostrarConfirmacion("¿Salir?", "Salir");
        if (opcion == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    public void iniciar() {
        SwingUtilities.invokeLater(() -> {
            setVisible(true);
            areaTexto.setText("Bienvenido a RipAdvisor\n");
        });
    }
}