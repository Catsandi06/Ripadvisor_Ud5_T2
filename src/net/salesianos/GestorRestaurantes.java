package net.salesianos;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que gestiona la lista de restaurantes.
 */
public class GestorRestaurantes {
    private List<Restaurante> restaurantes;

    public GestorRestaurantes() {
        restaurantes = new ArrayList<>();
    }

    public void anadirRestaurante(Restaurante restaurante) {
        restaurantes.add(restaurante);
    }

    public List<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public int getCantidad() {
        return restaurantes.size();
    }

    public boolean eliminarRestaurante(int indice) {
        if (indice >= 0 && indice < restaurantes.size()) {
            restaurantes.remove(indice);
            return true;
        }
        return false;
    }
}