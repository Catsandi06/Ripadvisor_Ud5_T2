package net.salesianos;

import javax.swing.JOptionPane;

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
}