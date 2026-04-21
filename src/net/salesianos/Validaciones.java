package net.salesianos;

import javax.swing.JOptionPane;

/**
 * Clase con metodos estaticos para validar datos y mostrar dialogos.
 */
public class Validaciones {

    public static boolean esCadenaVacia(String cadena) {
        return cadena == null || cadena.trim().isEmpty();
    }

    public static int solicitarEntero(String mensaje, String titulo) {
        String input = JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
        if (input == null || input.trim().isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static void mostrarMensaje(String mensaje, String titulo) {
        JOptionPane.showMessageDialog(null, mensaje, titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public static int mostrarConfirmacion(String mensaje, String titulo) {
        return JOptionPane.showConfirmDialog(null, mensaje, titulo, JOptionPane.YES_NO_OPTION);
    }

    public static String solicitarCadena(String mensaje, String titulo) {
        return JOptionPane.showInputDialog(null, mensaje, titulo, JOptionPane.QUESTION_MESSAGE);
    }

    public static boolean esPuntuacionValida(int puntuacion) {
        return puntuacion >= 1 && puntuacion <= 5;
    }
}