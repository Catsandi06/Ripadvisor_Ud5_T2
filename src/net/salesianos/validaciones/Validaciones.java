package net.salesianos;

import javax.swing.JOptionPane;

public class Validaciones {
    public static boolean esCadenaVacia(String cadena) {
        return cadena == null || cadena.trim().isEmpty();
    }
}