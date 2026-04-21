package net.salesianos.gestor;

import java.util.ArrayList;
import java.util.List;
import net.salesianos.restaurante.Restaurante;

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

    public boolean tieneRestaurantes() {
        return !restaurantes.isEmpty();
    }
}